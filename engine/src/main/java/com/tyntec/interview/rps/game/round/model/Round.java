package com.tyntec.interview.rps.game.round.model;

import com.tyntec.interview.rps.common.persistence.PersistentEntity;
import com.tyntec.interview.rps.player.Player;
import com.tyntec.interview.rps.player.PlayerChoice;
import com.tyntec.interview.rps.duel.Outcome;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Round implements PersistentEntity<String>, RoundInfo {
    private Integer count;
    private String id;
    private List<Player> players;
    private List<PlayerChoice> choices;
    private Outcome outcome;
    private RoundState state;

    @Override
    public boolean hasWinner() {
        return getOutcome().hasWinner();
    }
}
