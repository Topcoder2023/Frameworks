package com.gitee.frameworks;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import com.gitee.frameworks.common.CommonException;
import com.gitee.frameworks.common.ExecuteAble;
import com.gitee.frameworks.common.InitAble;
import com.gitee.frameworks.common.InitParam;
import com.gitee.frameworks.common.SortAble;
import com.gitee.frameworks.init.ScanInit;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * @author hongda.li@hand-china.com 2022/6/30 15:21
 */
@Slf4j
public class FrameworksBoot {
    @Getter
    private static InitParam initParam;

    public static void run() {
        run(null);
    }

    public static void run(String[] args) {
        try {
            boot(args);
        } catch (CommonException e) {
            throw new CommonException(((Supplier<String>) () -> {
                for (Props message : initParam.getMessages()) {
                    String str = message.getStr(e.getCode());
                    if (str != null) {
                        return StrUtil.format(str, e.getParams());
                    }
                }
                return e.getCode();
            }).get());
        }
    }

    private static void boot(String[] args) {
        initParam = InitParam.builder()
                .boot(CallerUtil.getCallerCaller())
                .args(args)
                .interval(new TimeInterval(false))
                .build();
        log.info("FrameworksBoot scanning");
        ScanInit.init(initParam);
        log.info("FrameworksBoot initialize: {}", initParam);
        SortAble.sort(InitAble.INITS).forEach(initAble -> initAble.doInit(initParam));
        log.info("FrameworksBoot execute module");
        SortAble.sort(ExecuteAble.EXECUTES).forEach(ExecuteAble::doExecute);
        log.info("FrameworksBoot start success: {} ms", initParam.getInterval().intervalMs());
    }
}
