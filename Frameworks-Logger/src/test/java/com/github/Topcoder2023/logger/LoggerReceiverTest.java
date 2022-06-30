package com.github.Topcoder2023.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LoggerReceiverTest {

    @Test
    public void debug() {
        log.debug("hello world");
    }
}