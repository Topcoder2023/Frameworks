package com.gitee.frameworks;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.caller.CallerUtil;
import com.gitee.frameworks.common.ExecuteAble;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:21
 */
@Slf4j
public class FrameworksBoot {
    @Getter
    private static InitParam initParam;

    public static void run(){
        run(null);
    }

    public static void run(String[] args){
        initParam = InitParam.builder()
                .boot(CallerUtil.getCallerCaller())
                .args(args)
                .interval(new TimeInterval(false))
                .build();
        log.info("FrameworksBoot initialize: {}", initParam);
        InitAble.INITS.forEach(InitAble::doInit);
        log.info("FrameworksBoot execute module");
        ExecuteAble.EXECUTES.forEach(ExecuteAble::doExecute);
        log.info("FrameworksBoot start success: {} ms", initParam.getInterval().intervalMs());
    }
}
