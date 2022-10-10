package com.tyntec.interview.rps.simulation.bot;

import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.symbol.Symbol;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.tyntec.interview.rps.common.random.RandomSymbol.nextSymbol;

@RequiredArgsConstructor
public class Bot {

    private final Player player;
    private List<PlayerChoice> choices = new ArrayList<>();

    public PlayerChoice nextChoice() {
        var selectedSymbol = makeAChoice();
        var choice = new PlayerChoice(player, selectedSymbol);
        choices.add(choice);
        return choice;
    }

    private Symbol makeAChoice() {
        if (choices.isEmpty()){
            return Symbol.PAPER;
        }
        return nextSymbol();
    }

    public Player getPlayer() {
        return player;
    }
}
