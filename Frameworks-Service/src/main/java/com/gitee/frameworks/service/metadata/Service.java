package com.gitee.frameworks.service.metadata;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hongda.li@hand-china.com 2022/6/30 17:10
 */
@Data
@Builder
@EqualsAndHashCode
public class Service {
    /**
     * 服务编码（雪花ID）
     */
    private final String id = IdUtil.getSnowflakeNextIdStr();
    /**
     * 服务名称
     */
    private String name;
    /**
     * host名称
     */
    private String host;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 端口号
     */
    private String port;
    /**
     * 注册时间
     */
    private String registerTime;
    /**
     * 续约时间
     */
    private String renewTime;
    /**
     * 服务状态
     */
    private Boolean state;

    /**
     * 校验上一次续约时间与当前时间的间隔是否小于指定数值
     *
     * @param dateTime 当前时间
     * @param second 指定间隔
     * @return 校验结果
     */
    public boolean valid(DateTime dateTime, int second) {
        renewTime = StrUtil.isEmpty(renewTime) ? registerTime : renewTime;
        return DateUtil.between(DateUtil.parseDateTime(renewTime), dateTime, DateUnit.SECOND) < second;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
