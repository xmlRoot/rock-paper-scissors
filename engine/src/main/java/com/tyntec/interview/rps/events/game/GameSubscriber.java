package com.tyntec.interview.rps.events.game;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.game.GameInfo;

import java.util.function.Consumer;

public interface GameSubscriber {

    Subscription onGameStarted(Consumer<GameInfo> callback);
    Subscription onGameCompleted(Consumer<GameInfo> callback);

    Subscription onGameOver(Consumer<GameInfo> callback);

}
