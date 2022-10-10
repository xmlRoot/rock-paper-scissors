package com.tyntec.interview.rps.simulation.bot;

import com.tyntec.interview.rps.player.PlayerFactory;

import java.util.Random;

public class BotFactory {

    public static final String BASE_BOT_NAME = "skynet-bot-";

    public Bot newBot(){
        var serialNumber = new Random().nextInt();
        var player = new PlayerFactory().newPlayer(BASE_BOT_NAME + serialNumber);
        return new Bot(player);
    }

}
