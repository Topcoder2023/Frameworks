package com.gitee.frameworks.common;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.setting.dialect.Props;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:23
 */
@Value
@Builder
@ToString
public class InitParam {
    Class<?> boot;
    String[] args;
    Set<Props> messages = new HashSet<>();
    TimeInterval interval;
    Set<Class<?>> classes = new HashSet<>();
    Environment env = Environment.env();
}
