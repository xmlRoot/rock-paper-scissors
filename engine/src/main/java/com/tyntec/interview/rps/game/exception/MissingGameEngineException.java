package com.tyntec.interview.rps.game.exception;

import com.tyntec.interview.rps.common.exception.GameException;

public class MissingGameEngineException extends GameException {

    public MissingGameEngineException(String message) {
        super(message);
    }
}
