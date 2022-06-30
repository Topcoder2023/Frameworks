package com.github.Topcoder2023.logger;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hongda.li@hand-china.com 2022/6/30 14:00
 */
public class LoggerFactory implements ILoggerFactory {
    private static final Map<String, Object> LOGGER_CACHE = new ConcurrentHashMap<>(1024);

    @Override
    public Logger getLogger(String s) {
        return (Logger) LOGGER_CACHE.computeIfAbsent(s, LoggerReceiver::new);
    }
}
