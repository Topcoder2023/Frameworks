package com.gitee.frameworks.common;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hongda.li@hand-china.com 2022/7/11 14:54
 */
@Value
public class Environment {
    private static final Environment ENVIRONMENT = new Environment();
    static ThreadLocal<Map<String, Object>> VARIABLE = new ThreadLocal<>();
    List<Props> props = new ArrayList<>();

    private Environment() {
    }

    public static Environment env() {
        return ENVIRONMENT;
    }

    /**
     * 获取当前系统时间
     *
     * @return 当前系统时间
     */
    public static String getSystemTime() {
        return DatePattern.NORM_DATETIME_MS_FORMAT.format(new DateTime());
    }

    /**
     * 设置当前语言
     *
     * @param lang 语言
     */
    public static void setLang(String lang) {
        Map<String, Object> map = VARIABLE.get();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("_LANG_", lang);
    }

    /**
     * 获取当前语言
     *
     * @return 语言
     */
    public static String getLang() {
        Map<String, Object> map = VARIABLE.get();
        if (map == null) {
            return StrUtil.EMPTY;
        }
        Object lang = map.get("_LANG_");
        return StrUtil.isEmptyIfStr(lang) ? StrUtil.EMPTY : String.valueOf(lang);
    }

    /**
     * 移除当前系统环境变量
     */
    public static void removeVariable() {
        VARIABLE.remove();
    }
}
