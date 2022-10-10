package com.tyntec.interview.rps.game;

import com.tyntec.interview.rps.common.UnitTest;
import com.tyntec.interview.rps.events.EventContext;
import com.tyntec.interview.rps.events.EventContextFactory;
import com.tyntec.interview.rps.game.builder.GameBuilder;
import com.tyntec.interview.rps.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompleteARoundTest extends UnitTest {

    private EventContext events = EventContextFactory.instance();
    private Player player1 = faker.players().human();
    private Player player2 = faker.players().human();
    private Game game = new GameBuilder()
            .addPlayer(player1)
            .addPlayer(player2)
            .setRoundCount(2)
            .build();

    @Test
    @DisplayName("test completing a round")
    public void testCompleteARound() {
        assertThat(game.getState()).isEqualTo(GameState.INITIALIZED);
        game.start();
        var player1Choice = faker.players().choice(player1);
        events.fireNewPlayerChoice(player1Choice);
        var player2Choice = faker.players().choice(player2);
        events.fireNewPlayerChoice(player2Choice);
        assertThat(game.getCompletedRounds()).isEqualTo(1);
        assertThat(game.getState()).isEqualTo(GameState.IN_PROGRESS);
        var result = game.getResult();
        assertThat(result).isNotNull();
        assertThat(result.roundCount()).isEqualTo(2); // we've moved to the next round
    }



}
