package com.tyntec.interview.rps.simulation;

import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.player.Player;

import java.util.List;

public interface SimulationOverHandler {

    void accept(List<Player> players, GameInfo game);
}
