package com.tyntec.interview.rps.simulation;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.events.EventContext;
import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.game.builder.GameBuilder;
import com.tyntec.interview.rps.simulation.bot.Bot;

import java.util.List;
import java.util.stream.IntStream;

public class SimulationRunner implements AutoCloseable {

    private final Bot first;
    private final Bot second;
    private final Integer roundCounter;

    private final EventContext events;

    private Subscription gameOverSub;
    private final SimulationOverHandler onGameOver;

    public SimulationRunner(
            Bot first,
            Bot second,
            Integer roundCounter,
            EventContext events,
            SimulationOverHandler onGameOver
    ) {
        this.first = first;
        this.second = second;
        this.roundCounter = roundCounter;
        this.events = events;
        this.onGameOver = onGameOver;
        gameOverSub = events.onGameOver(this::onGameOver);
    }

    private void onGameOver(GameInfo game){
        this.onGameOver.accept(List.of(first.getPlayer(), second.getPlayer()), game);
    }

    public void run(){
        var players = List.of(first, second);
        var builder = new GameBuilder().setRoundCount(roundCounter);
        players.forEach(bot -> builder.addPlayer(bot.getPlayer()));
        builder.build().start();

        IntStream.range(0, roundCounter).forEach(round -> {
            players.forEach(bot -> {
                events.fireNewPlayerChoice(bot.nextChoice());
            });
        });
    }

    @Override
    public void close() throws Exception {
        gameOverSub.unsubscribe();
    }
}
