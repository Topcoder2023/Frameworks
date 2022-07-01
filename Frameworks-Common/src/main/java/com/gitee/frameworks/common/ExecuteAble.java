package com.gitee.frameworks.common;

import java.util.HashSet;
import java.util.Set;

/**
 * 可执行接口
 *
 * @author hongda.li@hand-china.com 2022/6/30 15:47
 */
@FunctionalInterface
public interface ExecuteAble {
    Set<ExecuteAble> EXECUTES = new HashSet<>();

    /**
     * 执行
     */
    void doExecute();
}
