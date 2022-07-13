package com.github.Topcoder2023.logger.appender;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hongda.li@hand-china.com 2022/6/30 14:20
 */
public interface Appender {
    Set<Appender> APPENDER_SET = new HashSet<>();
    static void addAppender(Appender appender){
        APPENDER_SET.add(appender);
    }

    void debug(String msg, Object... params);
}
