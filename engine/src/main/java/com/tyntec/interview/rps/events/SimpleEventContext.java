package com.tyntec.interview.rps.events;


import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.events.game.GameEvents;
import com.tyntec.interview.rps.events.player.PlayerEvents;
import com.tyntec.interview.rps.events.round.RoundEvents;
import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.game.round.model.Round;
import com.tyntec.interview.rps.game.round.model.RoundInfo;
import com.tyntec.interview.rps.player.PlayerChoice;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

//                __ -> log.info("Game is about to start."),
//                __ -> log.info("Game is over."),
//                __ -> log.info("New Round is about to start."),
//                (round, state) -> log.info("Round {} is over with outcome of {}.",
//                        state.getCurrentRound(), round.outcome()),
//                (player, __ ) -> log.info("Player {} is about to make a choice.", player.name()),
//                (player, choice , __) -> log.info("Player {} made a move of {}.", player.name(), choice)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class SimpleEventContext implements EventContext {

    private final GameEvents gameEventsDelegate;
    private final RoundEvents roundEventsDelegate;
    private final PlayerEvents playerEventsDelegate;
    @Override
    public void fireGameStarted(GameInfo game) { gameEventsDelegate.fireGameStarted(game); }
    @Override
    public void fireGameCompleted(GameInfo game) { gameEventsDelegate.fireGameCompleted(game); }

    @Override
    public void fireGameOver(GameInfo game) {
        gameEventsDelegate.fireGameOver(game);
    }

    @Override
    public Subscription onGameStarted(Consumer<GameInfo> callback) {
        return gameEventsDelegate.onGameStarted(callback);
    }

    @Override
    public Subscription onGameCompleted(Consumer<GameInfo> callback) {
        return gameEventsDelegate.onGameCompleted(callback);
    }

    @Override
    public Subscription onGameOver(Consumer<GameInfo> callback) {
        return gameEventsDelegate.onGameOver(callback);
    }

    @Override
    public void fireRoundStarted(Integer count, String id) { roundEventsDelegate.fireRoundStarted(count,id); }
    @Override
    public void fireRoundCompleted(Round round) { roundEventsDelegate.fireRoundCompleted(round); }

    @Override
    public void fireNewPlayerChoice(PlayerChoice choice) {
        playerEventsDelegate.fireNewPlayerChoice(choice);
    }

    @Override
    public Subscription onPlayerChoice(Consumer<PlayerChoice> subscription) {
        return playerEventsDelegate.onPlayerChoice(subscription);
    }

    @Override
    public Subscription onRoundCompleted(Consumer<RoundInfo> subscription) {
        return roundEventsDelegate.onRoundCompleted(subscription);
    }
}
