package com.tyntec.interview.rps.events.round;

import com.tyntec.interview.rps.game.round.model.Round;

public interface RoundPublisher {
    void fireRoundStarted(Integer count, String id);
    void fireRoundCompleted(Round round);
}
