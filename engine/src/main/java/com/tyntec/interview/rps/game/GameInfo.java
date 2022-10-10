package com.tyntec.interview.rps.game;

import com.tyntec.interview.rps.game.round.model.RoundInfo;

public interface GameInfo {
    GameResult getResult();
    RoundInfo getLastRound();
    Integer getCompletedRounds();
    GameState getState();
    String getId();
}
