package com.tyntec.interview.rps.common.model;

import java.util.UUID;

public class UUIDGenerator {

    private UUIDGenerator() {}

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

}
