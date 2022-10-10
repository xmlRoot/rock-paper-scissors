package com.tyntec.interview.rps.faker;

import com.tyntec.interview.rps.events.game.GameEvents;
import com.tyntec.interview.rps.events.game.GamePublisher;
import com.tyntec.interview.rps.events.round.RoundEvents;
import com.tyntec.interview.rps.events.round.RoundPublisher;
import com.tyntec.interview.rps.game.Game;
import com.tyntec.interview.rps.game.GameConfiguration;
import com.tyntec.interview.rps.game.TwoPlayerGame;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FakeGame {

    private final RPSFaker faker;

    public Game simple() {
        return simple(new GameEvents(), new RoundEvents());
    }

    public Game simple(
            GamePublisher gameEvents,
            RoundPublisher roundEvents
    ){
        return new TwoPlayerGame(
                new GameConfiguration(100),
                faker.services().ruleEngine(),
                gameEvents,
                roundEvents,
                List.of(faker.players().human(), faker.players().bot()));
    }

}
