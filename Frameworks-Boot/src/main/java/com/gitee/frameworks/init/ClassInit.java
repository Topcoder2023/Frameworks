package com.gitee.frameworks.init;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.ClassUtil;
import com.gitee.frameworks.FrameworksBoot;
import com.gitee.frameworks.annotation.Scanner;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.SortAble;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 初始化加载Class文件
 *
 * @author hongda.li@hand-china.com 2022/6/30 15:24
 */
@EqualsAndHashCode
public class ClassInit implements InitAble, SortAble {
    @Getter
    private static final Set<Class<?>> CLASS_SET = new HashSet<>();
    public static final String PACKAGE_NAME = "com.gitee.frameworks";

    static {
        InitAble.INITS.add(new ClassInit());
    }

    @Override
    public void doInit() {
        InitParam param = FrameworksBoot.getInitParam();
        param.getInterval().start();
        scanClasses(param);
        param.setClasses(CLASS_SET);
    }

    @Override
    public Integer sort() {
        return setHighestPriority();
    }

    /**
     * 扫描并加载指定class文件
     *
     * @param param 初始化参数
     */
    private void scanClasses(InitParam param) {
        Set<Class<?>> root = ClassUtil.scanPackage(param.getBoot().getPackageName());
        Set<Class<?>> frameworks = ClassUtil.scanPackage(PACKAGE_NAME);
        CLASS_SET.addAll(root);
        CLASS_SET.addAll(frameworks);
        Optional.ofNullable(AnnotationUtil.getAnnotation(param.getBoot(), Scanner.class))
                .ifPresent(scanner -> Arrays.stream(scanner.value())
                        .forEach(item -> CLASS_SET.addAll(ClassUtil.scanPackage(item))));
    }
}
