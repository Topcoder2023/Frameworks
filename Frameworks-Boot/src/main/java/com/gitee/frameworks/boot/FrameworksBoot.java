package com.gitee.frameworks.boot;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.caller.CallerUtil;
import com.gitee.frameworks.common.CommonException;
import com.gitee.frameworks.common.ExecuteAble;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import com.gitee.frameworks.common.MessageReader;
import com.gitee.frameworks.common.SortAble;
import com.gitee.frameworks.boot.init.ScanInit;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:21
 */
@Slf4j
public class FrameworksBoot {
    @Getter
    private static InitParam initParam;
    private static final int CALLER_PATH = 3;

    /**
     * 无参启动
     */
    public static void run() {
        try {
            boot(null);
        } catch (CommonException e) {
            throw new CommonException(MessageReader.get(initParam.getMessages(), e.getCode(), e.getParams()));
        }
    }

    /**
     * 有参启动
     *
     * @param args 启动参数
     */
    public static void run(String[] args) {
        try {
            boot(args);
        } catch (CommonException e) {
            throw new CommonException(MessageReader.get(initParam.getMessages(), e.getCode(), e.getParams()));
        }
    }

    /**
     * 启动程序
     *
     * @param args 启动参数
     */
    private static void boot(String[] args) {
        // 初始化参数
        initParam = InitParam.builder()
                .boot(CallerUtil.getCaller(CALLER_PATH))
                .args(args)
                .interval(new TimeInterval(false))
                .build();

        // 初始化类扫描器
        ScanInit.init(initParam);

        // 执行初始化模块
        SortAble.sort(InitAble.INITS).forEach(initAble -> initAble.doInit(initParam));
        // 执行功能模块
        SortAble.sort(ExecuteAble.EXECUTES).forEach(ExecuteAble::doExecute);
    }
}
