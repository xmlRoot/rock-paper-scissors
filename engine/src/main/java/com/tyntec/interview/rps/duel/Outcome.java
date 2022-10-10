package com.tyntec.interview.rps.duel;

import com.tyntec.interview.rps.player.Player;

public interface Outcome {
    Boolean hasWinner();
    Player winner();
}
