package com.tyntec.interview.rps.common.event;

import java.util.function.Consumer;

public record EventSubscription<T>(
        Consumer<T> callback,
        Consumer<Subscription> onCancel
) implements Subscription {

    @Override
    public void unsubscribe() {
        onCancel.accept(this);
    }
}
