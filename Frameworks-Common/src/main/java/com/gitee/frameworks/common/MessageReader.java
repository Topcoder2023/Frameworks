package com.gitee.frameworks.common;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import java.util.Map;

/**
 * @author hongda.li@hand-china.com 2022/7/22 18:06
 */
public interface MessageReader {

    static String get(Map<String, Props> messages, String code, Object... params){
        String lang = Environment.getLang();
        for (Map.Entry<String, Props> entry : messages.entrySet()) {
            String name = entry.getKey();
            Props prop = entry.getValue();
            if (name.endsWith(lang)){
                String msg = prop.getStr(code);
                if (msg != null){
                    return StrUtil.format(msg, params);
                }
            }
        }
        return code;
    }
}
