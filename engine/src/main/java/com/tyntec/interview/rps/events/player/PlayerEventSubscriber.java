package com.tyntec.interview.rps.events.player;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.player.PlayerChoice;

import java.util.function.Consumer;

public interface PlayerEventSubscriber {

    Subscription onPlayerChoice(Consumer<PlayerChoice> callback);

}
