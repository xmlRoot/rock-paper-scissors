package com.tyntec.interview.rps.game;

public sealed interface Game extends GameInfo permits TwoPlayerGame {
    void start();
}
