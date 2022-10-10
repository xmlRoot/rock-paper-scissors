package com.tyntec.interview.rps.game;

import com.tyntec.interview.rps.common.UnitTest;
import com.tyntec.interview.rps.faker.event.FakeGameEvents;
import com.tyntec.interview.rps.faker.event.FakeRoundEvents;
import com.tyntec.interview.rps.game.round.model.RoundState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoPlayerGameTest extends UnitTest {

    private FakeGameEvents gameEvents = new FakeGameEvents();
    private FakeRoundEvents roundEvents = new FakeRoundEvents();

    private final Game game = faker.game().simple(gameEvents, roundEvents);

    @Test
    @DisplayName("test starting a game")
    public void testStartGame(){
        assertThat(game.getState()).isEqualTo(GameState.INITIALIZED);
        game.start();
        assertThat(game.getCompletedRounds()).isEqualTo(0);
        assertThat(game.getState()).isEqualTo(GameState.IN_PROGRESS);
        var round = game.getLastRound();
        assertThat(round).isNotNull();
        assertThat(round.getState()).isEqualTo(RoundState.STARTED);
        assertThat(gameEvents.counters.gameStarted).isEqualTo(1);
        assertThat(gameEvents.counters.gameEnded).isEqualTo(0);
        assertThat(roundEvents.counters.roundStarted).isEqualTo(1);
        assertThat(roundEvents.counters.roundCompleted).isEqualTo(0);
    }

}
