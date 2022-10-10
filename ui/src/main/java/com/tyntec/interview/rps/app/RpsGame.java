package com.tyntec.interview.rps.app;

import com.tyntec.interview.rps.simulation.SimulationOverHandler;
import com.tyntec.interview.rps.simulation.SimulationRunnerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "rps", mixinStandardHelpOptions = true,
        version = "rps 1.0",
        description = "Play a simple rock-paper-scissors game."
)
public class RpsGame implements Runnable {

    @Option(names = {"--rounds", "-r"},
            description = "Specify the number of rounds. Defaults to 100",
            paramLabel = "<num>"
    )
    Integer rounds = 100;

    @Option(names = {"--simulation", "-s"},
            description = "Run a simulation game, played by two bots."
    )
    Boolean simulation = false;

    @Override
    public void run() {
        if (simulation){
            runSimulation();
        }else {
            System.out.println("Not Yet implemented");
        }
    }

    private void runSimulation() {
        SimulationOverHandler onGameOver = (players, game) -> {
            var result = game.getResult();
            var score = result.score();
            System.out.printf("Player %s won %s of %d games\n",
                    players.get(0).name(), score.get(players.get(0).name()) , rounds);
            System.out.printf("Player %s won %d of %d games\n",
                    players.get(1).name(), score.get(players.get(1).name()) , rounds);
            System.out.printf("Tie: %d of %d games\n", result.ties(), rounds);
        };
        new SimulationRunnerFactory().newRunner(rounds, onGameOver).run();
    }

    public static void main(String[] args) {
        new CommandLine(new RpsGame()).execute(args);
    }

}
