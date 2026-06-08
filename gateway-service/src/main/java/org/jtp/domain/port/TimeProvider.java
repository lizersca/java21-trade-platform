package org.jtp.domain.port;

import java.time.Instant;

public interface TimeProvider {
    Instant now();
}