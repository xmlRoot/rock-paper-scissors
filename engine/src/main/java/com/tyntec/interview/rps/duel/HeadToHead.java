package com.tyntec.interview.rps.duel;

import com.tyntec.interview.rps.player.Player;

public record HeadToHead(Player winner) implements Outcome {
    @Override
    public Boolean hasWinner() {
        return winner != null;
    }
}
