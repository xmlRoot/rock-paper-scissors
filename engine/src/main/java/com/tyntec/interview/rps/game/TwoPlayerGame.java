package com.tyntec.interview.rps.game;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.common.exception.GameException;
import com.tyntec.interview.rps.events.game.GamePublisher;
import com.tyntec.interview.rps.events.round.RoundPublisher;
import com.tyntec.interview.rps.game.round.model.Round;
import com.tyntec.interview.rps.game.round.model.RoundInfo;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.duel.DuelEngine;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.tyntec.interview.rps.common.model.UUIDGenerator.uuid;
import static com.tyntec.interview.rps.game.round.model.RoundState.COMPLETED;
import static com.tyntec.interview.rps.game.round.model.RoundState.STARTED;

@Slf4j
public final class TwoPlayerGame implements Game {

    @Getter
    private final String id;
    private final DuelEngine rules;
    private final List<Round> rounds;
    private Round lastRound;
    private List<Player> players;
    private final GamePublisher gameEvents;
    private final RoundPublisher roundEvents;
    private final GameConfiguration configuration;
    @Setter
    private List<Subscription> eventSubscriptions;

    @Getter
    private GameState state = GameState.INITIALIZED;

    public TwoPlayerGame(
            GameConfiguration configuration,
            DuelEngine rules,
            GamePublisher gameEvents,
            RoundPublisher roundEvents,
            List<Player> players
    ) {
        this.rules = rules;
        this.players = players;
        this.roundEvents = roundEvents;
        this.gameEvents = gameEvents;
        this.configuration = configuration;
        rounds = new ArrayList<>(configuration.roundCount());
        id = uuid();
    }

    @Override
    public void start() {
        if (state == GameState.IN_PROGRESS){
            return;
        }
        if (state == GameState.COMPLETED){
            throw new GameException("You can't start a completed game. Restarts are not allowed.");
        }
        gameEvents.fireGameStarted(this);
        state = GameState.IN_PROGRESS;
        // begin round
        startNextRound();
    }

    private void startNextRound() {
        var round = generateNextRound();
        rounds.add(round);
        lastRound = round;
        roundEvents.fireRoundStarted(round.getCount(), round.getId());
    }

    private Round generateNextRound() {
        return Round.builder()
                .id(uuid())
                .count( lastRound == null ? 1 : lastRound.getCount() + 1)
                .choices(new ArrayList<>(players.size()))
                .players(players)
                .state(STARTED)
                .build();
    }

    public void onPlayerChoice(PlayerChoice choice){
        lastRound.getChoices().add(choice);
        if (lastRound.getChoices().size() == 2){
            completeRound();
        }
    }

    private void completeRound() {
        lastRound.setState(COMPLETED);
        var outcome = rules.match(lastRound.getChoices());
        lastRound.setOutcome(outcome);
        roundEvents.fireRoundCompleted(lastRound);
    }

    public void onRoundCompleted(RoundInfo round){
        if (round.getCount() >= configuration.roundCount()){
            gameEvents.fireGameCompleted(this);
            return;
        }
        startNextRound();
    }

    public void onGameCompleted(GameInfo game){
        log.info("Completed game id={}.", game.getId());
        log.debug("Completed game id={} with result {}", game.getId(), game.getResult());
        eventSubscriptions.forEach(Subscription::unsubscribe);
        state = GameState.COMPLETED;
        gameEvents.fireGameOver(this);
    }

    @Override
    public GameResult getResult() {
        return rounds.stream().filter(this::isCompleted).reduce(
                new GameResult(lastRound.getCount(), 0, new HashMap<>()),
                (acc, round) -> {
                    var outcome = round.getOutcome();
                    if ( outcome.hasWinner() ) {
                        var winCount = acc.score().getOrDefault(outcome.winner().name(), 0);
                        acc.score().put(outcome.winner().name(), winCount + 1);
                        return new GameResult(acc.roundCount(), acc.ties(), acc.score() );
                    }else {
                        return new GameResult(acc.roundCount(), acc.ties() + 1, acc.score());
                    }
                },
                (acc, round) -> acc
        );
    }

    private boolean isCompleted(Round r) {
        return r.getState() == COMPLETED;
    }

    @Override
    public RoundInfo getLastRound() {
        return lastRound;
    }

    @Override
    public Integer getCompletedRounds() {
        return Math.toIntExact(rounds.stream().filter(this::isCompleted).count());
    }
}
