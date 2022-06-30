package org.slf4j.impl;

import com.github.Topcoder2023.logger.LoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * 日志框架绑定器
 * 将自定义日志框架与Slf4j日志门面绑定
 *
 * @author hongda.li@hand-china.com 2022/6/30 13:58
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {
    /**
     * 日志框架绑定器实例
     */
    private static final StaticLoggerBinder LOGGER_BINDER = new StaticLoggerBinder();
    /**
     * 日志工厂类名
     */
    private static final String LOGGER_FACTORY_CLASS_NAME = LoggerFactory.class.getName();
    /**
     * 日志工厂实例
     */
    private final ILoggerFactory loggerFactory;

    private StaticLoggerBinder() {
        this.loggerFactory = new LoggerFactory();
    }

    public static StaticLoggerBinder getSingleton() {
        return LOGGER_BINDER;
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return StaticLoggerBinder.LOGGER_FACTORY_CLASS_NAME;
    }
}
