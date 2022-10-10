package com.tyntec.interview.rps.events.game;

import com.tyntec.interview.rps.common.event.EventSubscription;
import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.game.GameInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GameEvents implements GamePublisher, GameSubscriber{

    private List<EventSubscription<GameInfo>> gameStartedSubs = new ArrayList<>();
    private List<EventSubscription<GameInfo>> gameEndedSubs = new ArrayList<>();
    private List<EventSubscription<GameInfo>> gameOverSubs = new ArrayList<>();

    @Override
    public void fireGameStarted(GameInfo game) {
        gameStartedSubs.forEach(sub -> sub.callback().accept(game));
    }

    @Override
    public Subscription onGameStarted(Consumer<GameInfo> callback) {
        var sub = new EventSubscription<>(callback, gameStartedSubs::remove);
        gameStartedSubs.add(sub);
        return sub;                
    }

    @Override
    public Subscription onGameCompleted(Consumer<GameInfo> callback) {
        var sub = new EventSubscription<>(callback, gameEndedSubs::remove);
        gameEndedSubs.add(sub);
        return sub;
    }

    @Override
    public Subscription onGameOver(Consumer<GameInfo> callback) {
        var sub = new EventSubscription<>(callback, gameOverSubs::remove);
        gameOverSubs.add(sub);
        return sub;
    }

    @Override
    public void fireGameCompleted(GameInfo game) {
        new ArrayList<>(gameEndedSubs).forEach(sub -> sub.callback().accept(game));
    }

    @Override
    public void fireGameOver(GameInfo game) {
        new ArrayList<>(gameOverSubs).forEach(sub -> sub.callback().accept(game));
    }

}
