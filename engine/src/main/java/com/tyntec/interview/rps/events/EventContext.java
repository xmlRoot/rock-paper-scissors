package com.tyntec.interview.rps.events;


import com.tyntec.interview.rps.events.game.GamePublisher;
import com.tyntec.interview.rps.events.game.GameSubscriber;
import com.tyntec.interview.rps.events.player.PlayerEventPublisher;
import com.tyntec.interview.rps.events.player.PlayerEventSubscriber;
import com.tyntec.interview.rps.events.round.RoundPublisher;
import com.tyntec.interview.rps.events.round.RoundSubscriber;

public interface EventContext
        extends GamePublisher, GameSubscriber, RoundPublisher, RoundSubscriber,
                PlayerEventSubscriber, PlayerEventPublisher {

}
