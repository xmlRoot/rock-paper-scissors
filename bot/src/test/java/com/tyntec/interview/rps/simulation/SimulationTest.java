package com.tyntec.interview.rps.simulation;

import com.tyntec.interview.rps.game.GameResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimulationTest {

    @Test
    public void testRunSim(){
        int expectedRoundCount = 100;
        try (var sim =
                     new SimulationRunnerFactory().newRunner(expectedRoundCount, (players, game) -> {
                         assertThat(game).isNotNull();
                         GameResult result = game.getResult();
                         assertThat(result).isNotNull();
                         assertThat(result.roundCount()).isEqualTo(expectedRoundCount);
                     })){
            sim.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
