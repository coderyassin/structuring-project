package org.yascode.structuringproject.application.util;

import java.util.UUID;

public class CorrelationIdGenerator {

    public static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
