package com.tyntec.interview.rps.events;

import com.tyntec.interview.rps.game.GameInfo;
import com.tyntec.interview.rps.events.player.OnPlayerChoice;
import com.tyntec.interview.rps.game.round.model.Round;
import com.tyntec.interview.rps.player.Player;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface EventSubscriber {
    void onGameBeforeStart(Consumer<GameInfo> handler);
    void onGameAfterComplete(Consumer<GameInfo> handler);
    void onBeforeRound(Consumer<GameInfo> handler);
    void onAfterRound(BiConsumer<Round, GameInfo> handler);
    void onBeforePlayerMove(BiConsumer<Player, GameInfo> handler);
    void onAfterPlayerMove(OnPlayerChoice handler);
}
