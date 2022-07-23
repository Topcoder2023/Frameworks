package com.gitee.frameworks.boot.init;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.gitee.frameworks.boot.annotation.Scanner;
import com.gitee.frameworks.common.ExecuteAble;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author hongda.li@hand-china.com 2022/7/12 9:25
 */
@Slf4j
public class ScanInit {
    private static final AtomicBoolean BOOLEAN = new AtomicBoolean(false);
    private static final Set<Class<?>> CLASS_SET = new HashSet<>();
    private static final String PACKAGE_NAME = "com.gitee.frameworks";

    private ScanInit() {
    }

    public static void init(InitParam initParam) {
        if (BOOLEAN.get()) {
            log.warn("100");
            return;
        }
        BOOLEAN.set(true);
        initParam.getInterval().start();
        scanClasses(initParam);
        initParam.getClasses().addAll(CLASS_SET);
        handleInitAble(initParam.getClasses());
        handleExecuteAble(initParam.getClasses());
    }

    /**
     * 扫描并加载指定class文件
     *
     * @param param 初始化参数
     */
    private static void scanClasses(InitParam param) {
        Set<Class<?>> root = ClassUtil.scanPackage(param.getBoot().getPackageName());
        Set<Class<?>> frameworks = ClassUtil.scanPackage(PACKAGE_NAME);
        CLASS_SET.addAll(root);
        CLASS_SET.addAll(frameworks);
        Optional.ofNullable(AnnotationUtil.getAnnotation(param.getBoot(), Scanner.class))
                .ifPresent(scanner -> Arrays.stream(scanner.value())
                        .forEach(item -> CLASS_SET.addAll(ClassUtil.scanPackage(item))));
    }

    private static void handleExecuteAble(Set<Class<?>> classes) {
        classes.stream()
                .filter(clz -> clz != InitAble.class)
                .filter(InitAble.class::isAssignableFrom)
                .forEach(clazz -> {
                    log.info("102", clazz.getName());
                    InitAble instance = (InitAble) ReflectUtil.newInstance(clazz);
                    InitAble.INITS.add(instance);
                });
    }

    private static void handleInitAble(Set<Class<?>> classes) {
        classes.stream()
                .filter(clz -> clz != ExecuteAble.class)
                .filter(ExecuteAble.class::isAssignableFrom)
                .forEach(clazz -> {
                    log.info("101", clazz.getName());
                    ExecuteAble instance = (ExecuteAble) ReflectUtil.newInstance(clazz);
                    ExecuteAble.EXECUTES.add(instance);
                });
    }
}
