package com.gitee.frameworks.init;

import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import cn.hutool.system.SystemUtil;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import com.gitee.frameworks.common.SortAble;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author hongda.li@hand-china.com 2022/6/30 16:01
 */
@Slf4j
public class PropertyInit implements InitAble, SortAble {
    private static final String NAME = "config-path";
    private static final List<String> NAMES = Arrays.asList("application.properties", "config.properties", "app.properties");

    @Override
    public void doInit(InitParam initParam) {
        List<Props> props = initParam.getEnv().getProps();
        String path = SystemUtil.get(NAME);
        try {
            if (StrUtil.isNotEmpty(path)) {
                props.add(Props.getProp(path, StandardCharsets.UTF_8));
            }
        } catch (NoResourceException e) {
            log.warn("103", path);
        }
        NAMES.forEach(name -> {
            try {
                props.add(Props.getProp(name));
            } catch (NoResourceException ignored) {
            }
        });
    }

    @Override
    public Integer sort() {
        return setNormalPriority();
    }
}
