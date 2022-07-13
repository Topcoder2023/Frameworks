package com.gitee.frameworks.init;

import cn.hutool.setting.dialect.Props;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import com.gitee.frameworks.common.SortAble;

/**
 * @author hongda.li@hand-china.com 2022/7/11 14:33
 */
public class MessageInit implements InitAble, SortAble {
    @Override
    public void doInit(InitParam initParam) {
        initParam.getMessages().add(new Props("boot-message.properties"));
    }

    @Override
    public Integer sort() {
        return setNormalPriority();
    }
}
