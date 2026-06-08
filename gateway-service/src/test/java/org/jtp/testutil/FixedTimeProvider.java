package org.jtp.testutil;

import org.jtp.domain.port.TimeProvider;

import java.time.Instant;

public class FixedTimeProvider implements TimeProvider {

    private final Instant fixedInstant;

    public FixedTimeProvider(Instant fixedInstant) {
        this.fixedInstant = fixedInstant;
    }

    @Override
    public Instant now() {
        return fixedInstant;
    }
}