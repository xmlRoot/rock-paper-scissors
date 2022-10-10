package com.tyntec.interview.rps.faker;

import com.tyntec.interview.rps.common.random.RandomSymbol;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.player.PlayerFactory;
import com.tyntec.interview.rps.symbol.Symbol;
import lombok.RequiredArgsConstructor;

import static com.tyntec.interview.rps.common.random.RandomSymbol.nextSymbol;

@RequiredArgsConstructor
public class FakePlayers {

    private final RPSFaker faker;

    public Player human() {
        return new PlayerFactory().newPlayer(faker.name().fullName());
    }

    public Player bot() {
        return new PlayerFactory().newPlayer("skynet-alpha-2");
    }

    public PlayerChoice choice() {
        return choice(bot());
    }

    public PlayerChoice choice(Player player) {
        return choice(player, nextSymbol());
    }

    public PlayerChoice choice(Player player, Symbol symbol) {
        return new PlayerChoice(player, symbol);
    }

}
