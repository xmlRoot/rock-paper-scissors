package com.tyntec.interview.rps.game.exception;

import com.tyntec.interview.rps.common.exception.GameException;

public class TooManyPlayersException extends GameException {

    public TooManyPlayersException(String message) {
        super(message);
    }
}
