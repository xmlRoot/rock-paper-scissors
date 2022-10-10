package com.tyntec.interview.rps.simulation;

import com.tyntec.interview.rps.events.EventContextFactory;
import com.tyntec.interview.rps.simulation.bot.BotFactory;

public class SimulationRunnerFactory {

    private final BotFactory botFactory = new BotFactory();

    public SimulationRunner newRunner(
            Integer roundCounter,
            SimulationOverHandler onGameOver
    ) {
        return new SimulationRunner(
            botFactory.newBot(),
            botFactory.newBot(),
            roundCounter,
            EventContextFactory.instance(),
            onGameOver
        );
    }

}
