package com.tyntec.interview.rps.faker;

import com.github.javafaker.Faker;
import com.tyntec.interview.rps.common.model.UUIDGenerator;

public class RPSFaker extends Faker {

    public static final RPSFaker FAKER_INSTANCE = new RPSFaker();

    private RPSFaker() {}

    public FakePlayers players() {
        return new FakePlayers(this);
    }

    public FakeService services() {
        return new FakeService(this);
    }

    public String uuid(){
        return UUIDGenerator.uuid();
    }

    public FakeGame game() {
        return new FakeGame(this);
    }
}
