package com.tyntec.interview.rps.player;

import static com.tyntec.interview.rps.common.model.UUIDGenerator.uuid;

public class PlayerFactory {

    public Player newPlayer(String name){
        return new SimplePlayer(name, uuid());
    }
}
