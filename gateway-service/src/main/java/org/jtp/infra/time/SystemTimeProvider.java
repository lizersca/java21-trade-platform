package org.jtp.infra.time;

import lombok.RequiredArgsConstructor;
import org.jtp.domain.port.TimeProvider;

import java.time.Clock;
import java.time.Instant;

@RequiredArgsConstructor
public class SystemTimeProvider implements TimeProvider {

    private final Clock clock;

    @Override
    public Instant now() {
        return Instant.now(clock);
    }
}