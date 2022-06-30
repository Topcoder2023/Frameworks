package com.github.Topcoder2023.logger;

import org.slf4j.Marker;

/**
 * @author hongda.li@hand-china.com 2022/6/30 14:00
 */
public final class LoggerReceiver implements org.slf4j.Logger {
    private final String name;

    public LoggerReceiver(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String s) {}

    @Override
    public void trace(String s, Object o) {}

    @Override
    public void trace(String s, Object o, Object o1) {}

    @Override
    public void trace(String s, Object... objects) {}

    @Override
    public void trace(String s, Throwable throwable) {}

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String s) {

    }

    @Override
    public void trace(Marker marker, String s, Object o) {

    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {

    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {

    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {

    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String s) {}

    @Override
    public void debug(String s, Object o) {}

    @Override
    public void debug(String s, Object o, Object o1) {}

    @Override
    public void debug(String s, Object... objects) {}

    @Override
    public void debug(String s, Throwable throwable) {}

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String s) {}

    @Override
    public void debug(Marker marker, String s, Object o) {}

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {}

    @Override
    public void debug(Marker marker, String s, Object... objects) {}

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {}

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String s) {

    }

    @Override
    public void info(String s, Object o) {

    }

    @Override
    public void info(String s, Object o, Object o1) {

    }

    @Override
    public void info(String s, Object... objects) {

    }

    @Override
    public void info(String s, Throwable throwable) {

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String s) {}

    @Override
    public void info(Marker marker, String s, Object o) {}

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {}

    @Override
    public void info(Marker marker, String s, Object... objects) {}

    @Override
    public void info(Marker marker, String s, Throwable throwable) {}

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String s) {}

    @Override
    public void warn(String s, Object o) {}

    @Override
    public void warn(String s, Object... objects) {}

    @Override
    public void warn(String s, Object o, Object o1) {}

    @Override
    public void warn(String s, Throwable throwable) {}

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String s) {}

    @Override
    public void warn(Marker marker, String s, Object o) {}

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {}

    @Override
    public void warn(Marker marker, String s, Object... objects) {}

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {}

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String s) {

    }

    @Override
    public void error(String s, Object o) {

    }

    @Override
    public void error(String s, Object o, Object o1) {

    }

    @Override
    public void error(String s, Object... objects) {

    }

    @Override
    public void error(String s, Throwable throwable) {

    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String s) {}

    @Override
    public void error(Marker marker, String s, Object o) {}

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {}

    @Override
    public void error(Marker marker, String s, Object... objects) {}

    @Override
    public void error(Marker marker, String s, Throwable throwable) {}
}
