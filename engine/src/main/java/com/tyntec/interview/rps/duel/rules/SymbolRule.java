package com.tyntec.interview.rps.duel.rules;

import com.tyntec.interview.rps.duel.HeadToHeadOutcome;
import com.tyntec.interview.rps.symbol.Symbol;

public interface SymbolRule {
    HeadToHeadOutcome match(Symbol symbol);

    Symbol symbol();
}
