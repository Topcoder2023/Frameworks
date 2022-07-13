package com.github.Topcoder2023.logger.appender;

/**
 * @author hongda.li@hand-china.com 2022/6/30 14:18
 */
public class ConsoleAppender implements Appender {
    static {
        APPENDER_SET.add(new ConsoleAppender());
    }

    @Override
    public void debug(String msg, Object... params) {

    }
}
