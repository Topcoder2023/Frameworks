package com.gitee.frameworks.common;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.setting.dialect.Props;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:23
 */
@Data
@Builder
@ToString
public class InitParam {
    private Class<?> boot;
    private String[] args;
    private TimeInterval interval;
    private Set<Class<?>> classes;
    private Props props;
}
