package com.tyntec.interview.rps.events.player;

import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;

@FunctionalInterface
public interface OnPlayerChoice {
    void accept(Player player, PlayerChoice choice, GameInfo game);
}
