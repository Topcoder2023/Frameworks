package com.gitee.frameworks.common;

import cn.hutool.setting.dialect.Props;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongda.li@hand-china.com 2022/7/11 14:54
 */
@Value
public class Environment {
    private static final Environment ENVIRONMENT = new Environment();
    List<Props> props = new ArrayList<>();

    private Environment(){}

    public static Environment env(){
        return ENVIRONMENT;
    }
}
