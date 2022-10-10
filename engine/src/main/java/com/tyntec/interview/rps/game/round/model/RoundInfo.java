package com.tyntec.interview.rps.game.round.model;

import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.duel.Outcome;

import java.util.List;

public interface RoundInfo {

    boolean hasWinner();

    Integer getCount();

    List<Player> getPlayers();

    List<PlayerChoice> getChoices();

    Outcome getOutcome();

    RoundState getState();
}
