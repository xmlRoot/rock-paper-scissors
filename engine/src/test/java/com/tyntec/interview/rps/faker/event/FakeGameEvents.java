package com.tyntec.interview.rps.faker.event;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.events.game.GamePublisher;
import com.tyntec.interview.rps.events.game.GameSubscriber;
import com.tyntec.interview.rps.game.GameInfo;

import java.util.function.Consumer;

public class FakeGameEvents implements GamePublisher, GameSubscriber {

    public Counters counters = new Counters();

    public class Counters {
        public int gameStarted;
        public int gameEnded;
    }

    @Override
    public void fireGameStarted(GameInfo game) {
        counters.gameStarted++;
    }

    @Override
    public void fireGameCompleted(GameInfo game) {
        counters.gameEnded++;
    }

    @Override
    public void fireGameOver(GameInfo game) {

    }

    @Override
    public Subscription onGameStarted(Consumer<GameInfo> callback) {
        return null;
    }

    @Override
    public Subscription onGameCompleted(Consumer<GameInfo> callback) {
        return null;
    }

    @Override
    public Subscription onGameOver(Consumer<GameInfo> callback) {
        return null;
    }
}
