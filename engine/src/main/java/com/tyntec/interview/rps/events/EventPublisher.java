package com.tyntec.interview.rps.events;

import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.game.round.model.Round;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;

public interface EventPublisher {
    void fireGameBeforeStart(GameInfo game);
    void fireGameAfterComplete(GameInfo game);
    void fireBeforeRound(Integer roundCount, GameInfo game);
    void fireAfterRound(Round round, GameInfo game);
    void fireBeforePlayerMove(Player player, GameInfo game);
    void fireAfterPlayerMove(Player player, PlayerChoice choice, GameInfo game);
}
