package com.tyntec.interview.rps.duel;

import com.tyntec.interview.rps.player.PlayerChoice;

import java.util.List;

public interface DuelEngine {
    Outcome match(List<PlayerChoice> choices);
}
