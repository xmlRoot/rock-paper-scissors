package com.tyntec.interview.rps.duel;

import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.duel.rules.SymbolRule;
import com.tyntec.interview.rps.symbol.Symbol;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoPlayerDuelEngine implements DuelEngine {

    private final Map<Symbol, SymbolRule> rules;

    public TwoPlayerDuelEngine(List<SymbolRule> rules) {
        this.rules =
                rules.stream().collect(Collectors.toMap(SymbolRule::symbol, Function.identity()));
    }

    @Override
    public Outcome match(List<PlayerChoice> choices) {
        // TODO assert only two choices exist
        var left = choices.get(0);
        var right = choices.get(1);
        var rule = rules.get(left.choice());
        return switch (rule.match(right.choice())){
            case TIE -> new HeadToHead(null);
            case WIN -> new HeadToHead(left.player());
            case LOSE -> new HeadToHead(right.player());
        };
    }
}
