package com.gitee.frameworks.common;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    Map<String, Props> messages = new HashMap<>();
    TimeInterval interval;
    Set<Class<?>> classes = new HashSet<>();
    Environment env = Environment.env();

    public InitParam addMessage(String name){
        this.messages.put(name, Props.getProp(StrUtil.addSuffixIfNot(name, ".properties"), StandardCharsets.UTF_8));
        return this;
    }
}
