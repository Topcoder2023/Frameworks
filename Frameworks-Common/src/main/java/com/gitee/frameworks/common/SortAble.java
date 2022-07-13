package com.gitee.frameworks.common;

import cn.hutool.core.util.ReflectUtil;

import java.util.List;

/**
 * 可排序接口
 *
 * @author hongda.li@hand-china.com 2022/6/30 15:40
 */
@FunctionalInterface
public interface SortAble {

    int BEAN_INIT = -10000;

    int WEB_INIT = 10000;

    /**
     * 排序优先级
     *
     * @return 优先级序号，数字越低，优先级越高
     */
    Integer sort();

    /**
     * 获取指定类的优先级
     *
     * @param clazz 可排序的类
     * @return 优先级
     */
    default Integer getPriority(Class<? extends SortAble> clazz) {
        return ReflectUtil.invoke(ReflectUtil.newInstance(clazz), "sort");
    }

    /**
     * 最高优先级
     *
     * @return 0x80000000
     */
    default Integer setHighestPriority() {
        return Integer.MIN_VALUE;
    }

    /**
     * 最低优先级
     *
     * @return 0x7fffffff
     */
    default Integer setLowestPriority() {
        return Integer.MAX_VALUE;
    }

    /**
     * 普通优先级
     *
     * @return 0
     */
    default Integer setNormalPriority() {
        return 0;
    }

    /**
     * 在Bean模块初始化后
     *
     * @return -9999
     */
    default Integer afterBeanInit() {
        return BEAN_INIT + 1;
    }

    /**
     * 在Bean模块初始化前
     *
     * @return -10001
     */
    default Integer beforeBeanInit() {
        return BEAN_INIT - 1;
    }

    /**
     * 在Web模块初始化后
     *
     * @return 10001
     */
    default Integer afterWebInit() {
        return WEB_INIT + 1;
    }

    /**
     * 在Web模块初始化前
     *
     * @return 9999
     */
    default Integer beforeWebInit() {
        return WEB_INIT - 1;
    }

    /**
     * 对给定的List进行排序
     *
     * @param list list集合
     * @param <T>  任意元素泛型
     * @return 排序后的集合
     */
    static <T> List<T> sort(List<T> list) {
        list.sort((o1, o2) -> {
            int sort1 = 0, sort2 = 0;
            if (o1 instanceof SortAble) {
                sort1 = ((SortAble) o1).sort();
            }
            if (o2 instanceof SortAble) {
                sort2 = ((SortAble) o2).sort();
            }
            return (sort1 - sort2);
        });
        return list;
    }
}
