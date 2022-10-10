package com.tyntec.interview.rps.game.exception;

import com.tyntec.interview.rps.common.exception.GameException;

public class NoPlayersFoundException extends GameException {

    public NoPlayersFoundException(String message) {
        super(message);
    }
}
