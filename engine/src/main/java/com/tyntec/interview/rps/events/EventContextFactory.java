package com.tyntec.interview.rps.events;

import com.tyntec.interview.rps.events.game.GameEvents;
import com.tyntec.interview.rps.events.player.PlayerEvents;
import com.tyntec.interview.rps.events.round.RoundEvents;

public class EventContextFactory {
    private static EventContext INSTANCE;
    public static EventContext instance(){
        if (INSTANCE == null){
            INSTANCE = new SimpleEventContext(
                    new GameEvents(), new RoundEvents(), new PlayerEvents()
            );
        }
        return INSTANCE;
    }

}
