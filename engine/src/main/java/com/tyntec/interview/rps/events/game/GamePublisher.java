package com.tyntec.interview.rps.events.game;

import com.tyntec.interview.rps.game.GameInfo;

public interface GamePublisher {

    void fireGameStarted(GameInfo game);
    void fireGameCompleted(GameInfo game);
    void fireGameOver(GameInfo game);
}
