package com.gitee.frameworks.service.metadata;

import cn.hutool.core.date.DateTime;

/**
 * @author hongda.li@hand-china.com 2022/6/30 17:34
 */
public class Test {
    public static void main(String[] args) {
        Service localhost = Service.builder()
                .ip("127.0.0.1")
                .host("localhost")
                .name("test-service")
                .registerTime(DateTime.now().toString())
                .build();
        System.out.println(DateTime.now());
        System.out.println(localhost.valid(DateTime.now(), 10));
    }
}
