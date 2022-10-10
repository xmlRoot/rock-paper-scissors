package com.tyntec.interview.rps.faker;

import com.tyntec.interview.rps.duel.rules.PaperRule;
import com.tyntec.interview.rps.duel.rules.RockRule;
import com.tyntec.interview.rps.duel.DuelEngine;
import com.tyntec.interview.rps.duel.rules.ScissorsRule;
import com.tyntec.interview.rps.duel.TwoPlayerDuelEngine;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FakeService {

    private final RPSFaker faker;

    public DuelEngine ruleEngine() {
        return new TwoPlayerDuelEngine(List.of(
                new PaperRule(),
                new ScissorsRule(),
                new RockRule()
        ));
    }

}
