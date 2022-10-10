package com.tyntec.interview.rps.events.player;

import com.tyntec.interview.rps.player.PlayerChoice;

public interface PlayerEventPublisher {

    void fireNewPlayerChoice(PlayerChoice choice);

}
