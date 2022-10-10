package com.tyntec.interview.rps.duel.rules;

import com.tyntec.interview.rps.duel.HeadToHeadOutcome;
import com.tyntec.interview.rps.symbol.Symbol;
import static com.tyntec.interview.rps.duel.HeadToHeadOutcome.LOSE;
import static com.tyntec.interview.rps.duel.HeadToHeadOutcome.TIE;
import static com.tyntec.interview.rps.duel.HeadToHeadOutcome.WIN;

public record ScissorsRule() implements SymbolRule {

    @Override
    public HeadToHeadOutcome match(Symbol symbol) {
        return switch (symbol) {
            case ROCK -> LOSE;
            case PAPER -> WIN;
            case SCISSORS -> TIE;
        };
    }

    @Override
    public Symbol symbol() {
        return Symbol.SCISSORS;
    }
}
