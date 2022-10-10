package com.tyntec.interview.rps.faker.event;

import com.tyntec.interview.rps.events.round.RoundPublisher;
import com.tyntec.interview.rps.game.round.model.Round;

public class FakeRoundEvents implements RoundPublisher {

    public Counters counters = new Counters();

    public class Counters {
        public int roundStarted;
        public int roundCompleted;
    }

    @Override
    public void fireRoundStarted(Integer count, String id) {
        counters.roundStarted++;
    }

    @Override
    public void fireRoundCompleted(Round round) {
        counters.roundCompleted++;
    }
}
