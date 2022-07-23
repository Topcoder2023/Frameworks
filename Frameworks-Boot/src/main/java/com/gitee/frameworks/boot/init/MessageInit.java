package com.gitee.frameworks.boot.init;

import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import com.gitee.frameworks.common.SortAble;

/**
 * @author hongda.li@hand-china.com 2022/7/11 14:33
 */
public class MessageInit implements InitAble, SortAble {

    @Override
    public Integer sort() {
        return setNormalPriority();
    }

    @Override
    public void doInit(InitParam param) {
        param.addMessage("boot-message").addMessage("boot-message-zh-cn");
    }
}
