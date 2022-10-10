package com.tyntec.interview.rps.game.builder;

import com.tyntec.interview.rps.common.event.Subscription;
import com.tyntec.interview.rps.events.EventContext;
import com.tyntec.interview.rps.events.EventContextFactory;
import com.tyntec.interview.rps.game.Game;
import com.tyntec.interview.rps.game.GameConfiguration;
import com.tyntec.interview.rps.game.TwoPlayerGame;
import com.tyntec.interview.rps.game.exception.NoPlayersFoundException;
import com.tyntec.interview.rps.game.exception.NoRulesSetException;
import com.tyntec.interview.rps.game.exception.TooManyPlayersException;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.duel.DuelEngine;
import com.tyntec.interview.rps.duel.DuelEngineFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GameBuilder {

    static final Integer REQUIRED_PLAYER_COUNT = 2;
    private List<Player> players = new ArrayList<>(REQUIRED_PLAYER_COUNT);
    private Integer roundCount;
    private DuelEngine rules = DuelEngineFactory.twoPlayerRules();

    public GameBuilder addPlayer(Player player) {
        if (players.size() == REQUIRED_PLAYER_COUNT){
            log.error("Attempting to add a {} player, when only {} are allowed.",
                    REQUIRED_PLAYER_COUNT + 1 , REQUIRED_PLAYER_COUNT);
            throw new TooManyPlayersException("You can have only 2 players");
        }
        players.add(player);
        log.debug("Adding new player to the game.");
        return this;
    }

    public GameBuilder setRoundCount(Integer count) {
        roundCount = count;
        log.debug("Setting player count to {}", count);
        return this;
    }

    public Game build() {
        validate();
        var config = new GameConfiguration(roundCount);
        var events = EventContextFactory.instance();
        var game = new TwoPlayerGame(config, rules, events, events, players);
        game.setEventSubscriptions(registerEvents(events, game));
        return game;
    }

    private List<Subscription> registerEvents(EventContext events, TwoPlayerGame game) {
        return List.of(
          events.onPlayerChoice(game::onPlayerChoice),
          events.onRoundCompleted(game::onRoundCompleted),
          events.onGameCompleted(game::onGameCompleted)
        );
    }

    private void validate(){
        if (players.isEmpty() || players.size() < REQUIRED_PLAYER_COUNT){
            log.error("A game needs {} players. Currently there are {}.", REQUIRED_PLAYER_COUNT, players.size());
            throw new NoPlayersFoundException("A game needs %d players!".formatted(REQUIRED_PLAYER_COUNT));
        }
        if (rules == null){
            log.error("Game's rules are not yet set.");
            throw new NoRulesSetException("No Rules have been set for this game.");
        }
    }

}
