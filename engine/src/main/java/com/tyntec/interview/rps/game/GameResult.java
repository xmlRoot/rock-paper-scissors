package com.tyntec.interview.rps.game;

import java.util.Map;

public record GameResult(
    Integer roundCount,
    Integer ties,
    Map<String, Integer> score
) { }
