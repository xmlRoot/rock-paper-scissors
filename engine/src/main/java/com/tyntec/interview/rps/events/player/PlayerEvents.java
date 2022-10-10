package com.tyntec.interview.rps.events.player;

import com.tyntec.interview.rps.common.event.EventSubscription;
import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.player.PlayerChoice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerEvents implements PlayerEventSubscriber , PlayerEventPublisher{

    private List<EventSubscription<PlayerChoice>> playerChoiceSubs = new ArrayList<>();

    @Override
    public Subscription onPlayerChoice(Consumer<PlayerChoice> callback) {
        var sub = new EventSubscription<>(callback, playerChoiceSubs::remove);
        playerChoiceSubs.add(sub);
        return sub;
    }

    @Override
    public void fireNewPlayerChoice(PlayerChoice choice) {
        new ArrayList<>(playerChoiceSubs).forEach(sub -> sub.callback().accept(choice));
    }
}
