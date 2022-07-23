package com.gitee.frameworks.data.entity;


import cn.hutool.core.util.IdUtil;
import com.gitee.frameworks.common.Environment;
import lombok.Data;

/**
 * @author hongda.li@hand-china.com 2022/7/23 14:43
 */
@Data
public class EntityDomain {
    private Long id;
    private String createTime;
    private String updateTime;
    private Long version;

    /**
     * 生成雪花ID
     * @return 雪花ID
     */
    public Long id(){
        return IdUtil.getSnowflakeNextId();
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public String time(){
        return Environment.getSystemTime();
    }
}
