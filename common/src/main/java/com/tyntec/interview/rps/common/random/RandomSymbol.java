package com.tyntec.interview.rps.common.random;

import com.tyntec.interview.rps.symbol.Symbol;

import java.util.Random;

public class RandomSymbol {

    private RandomSymbol() {}

    public static Symbol nextSymbol(){
        var randomGen = new Random();
        var allSymbols = Symbol.values();
        var index = randomGen.nextInt(0, allSymbols.length);
        return allSymbols[index];
    }

}
