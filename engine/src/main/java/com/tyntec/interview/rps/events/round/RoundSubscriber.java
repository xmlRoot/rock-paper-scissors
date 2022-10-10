package com.tyntec.interview.rps.events.round;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.game.round.model.RoundInfo;

import java.util.function.Consumer;

public interface RoundSubscriber {
    Subscription onRoundCompleted(Consumer<RoundInfo> subscription);
}
