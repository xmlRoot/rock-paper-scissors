package com.tyntec.interview.rps.events.round;

import com.tyntec.interview.rps.common.event.EventSubscription;
import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.game.round.model.Round;
import com.tyntec.interview.rps.game.round.model.RoundInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RoundEvents implements RoundPublisher, RoundSubscriber {

    private List<EventSubscription<RoundInfo>> roundCompletedSubs = new ArrayList<>();

    @Override
    public void fireRoundStarted(Integer count, String id) {

    }

    @Override
    public void fireRoundCompleted(Round round) {
        new ArrayList<>(roundCompletedSubs).forEach(sub -> sub.callback().accept(round));
    }

    @Override
    public Subscription onRoundCompleted(Consumer<RoundInfo> subscription) {
        var sub = new EventSubscription<>(subscription, roundCompletedSubs::remove);
        roundCompletedSubs.add(sub);
        return sub;
    }
}
