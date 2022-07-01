package com.gitee.frameworks.common;


import java.util.HashSet;
import java.util.Set;

/**
 * 可初始化接口
 *
 * @author hongda.li@hand-china.com 2022/6/30 15:22
 */
@FunctionalInterface
public interface InitAble {
    /**
     * 可初始化接口的实现类集合
     */
    Set<InitAble> INITS = new HashSet<>();

    /**
     * 执行初始化操作
     */
    void doInit();
}
