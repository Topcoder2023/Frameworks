package com.gitee.frameworks.common;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:50
 */
@FunctionalInterface
public interface FilterAble<T> {

    /**
     * 执行过滤
     *
     * @param t 未过滤元素
     * @return 是否执行后续过滤
     */
    boolean doFilter(T t);
}
