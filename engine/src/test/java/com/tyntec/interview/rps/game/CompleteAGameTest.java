package com.tyntec.interview.rps.game;

import com.tyntec.interview.rps.common.UnitTest;
import com.tyntec.interview.rps.events.EventContext;
import com.tyntec.interview.rps.events.EventContextFactory;
import com.tyntec.interview.rps.game.builder.GameBuilder;
import com.tyntec.interview.rps.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static com.tyntec.interview.rps.game.GameState.COMPLETED;
import static org.assertj.core.api.Assertions.assertThat;

public class CompleteAGameTest extends UnitTest {

    private EventContext events = EventContextFactory.instance();
    private Player player1 = faker.players().human();
    private Player player2 = faker.players().human();

    private static final Integer GAME_ROUNDS_COUNT = 10;

    private Game game = buildTestGame();

    private Game buildTestGame() {
        return new GameBuilder()
                .addPlayer(player1)
                .addPlayer(player2)
                .setRoundCount(GAME_ROUNDS_COUNT)
                .build();
    }

    @Test
    public void testCompleteAGame(){
        assertThat(game.getState()).isEqualTo(GameState.INITIALIZED);
        game.start();
        assertThat(game.getState()).isEqualTo(GameState.IN_PROGRESS);
        runAllGameRounds();
        assertThat(game.getState()).isEqualTo(COMPLETED);
        GameResult result = game.getResult();
        assertThat(game.getCompletedRounds())
                .isEqualTo(GAME_ROUNDS_COUNT)
                .isEqualTo(result.roundCount());
    }

    private void runAllGameRounds() {
        IntStream.range(0, GAME_ROUNDS_COUNT).forEach( i -> {
            events.fireNewPlayerChoice(faker.players().choice(player1));
            events.fireNewPlayerChoice(faker.players().choice(player2));
        });
    }


    @Test
    public void testStartAGameAfterOneIsCompleted(){
        testCompleteAGame();
        var newGame = buildTestGame();
        newGame.start();
        runAllGameRounds();
        assertThat(newGame.getState()).isEqualTo(COMPLETED);
    }

}
