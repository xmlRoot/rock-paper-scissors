package com.tyntec.interview.rps.game.exception;

import com.tyntec.interview.rps.common.exception.GameException;

public class NoRulesSetException extends GameException {
    public NoRulesSetException(String message) {
        super(message);
    }
}
