package com.gitee.frameworks.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 可执行接口
 *
 * @author hongda.li@hand-china.com 2022/6/30 15:47
 */
@FunctionalInterface
public interface ExecuteAble {
    List<ExecuteAble> EXECUTES = new ArrayList<>();

    /**
     * 执行
     */
    void doExecute();
}
