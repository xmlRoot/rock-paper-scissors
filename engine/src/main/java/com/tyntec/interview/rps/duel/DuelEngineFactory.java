package com.tyntec.interview.rps.duel;

import com.tyntec.interview.rps.duel.rules.PaperRule;
import com.tyntec.interview.rps.duel.rules.RockRule;
import com.tyntec.interview.rps.duel.rules.ScissorsRule;

import java.util.List;

public class DuelEngineFactory {

    private static DuelEngine TWO_PLAYER_RULES;

    public static DuelEngine twoPlayerRules() {
        if (TWO_PLAYER_RULES == null) {
            TWO_PLAYER_RULES = new TwoPlayerDuelEngine(List.of(
                    new RockRule(), new PaperRule(), new ScissorsRule()
            ));
        }
        return TWO_PLAYER_RULES;
    }

}
