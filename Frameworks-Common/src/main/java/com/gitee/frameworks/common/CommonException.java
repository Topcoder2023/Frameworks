package com.gitee.frameworks.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用异常类
 * 支持从配置文件中通过消息编码获取消息
 *
 * @author hongda.li@hand-china.com 2022/7/1 9:45
 */
@Getter
@Setter
public class CommonException extends RuntimeException {
    private String code;
    private Object[] params;

    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable throwable) {
        super(throwable);
    }

    public CommonException(String code, Object... params) {
        this.code = code;
        this.params = params;
    }
}
