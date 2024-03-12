package net.cocotea.admin.api.system.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 系统通知视图
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Data
@Accessors(chain = true)
public class SysNotifyVO {

    /**
     * 消息ID
     */
    private BigInteger id;

    /**
     * 通知标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String memo;

    /**
     * 跳转链接
     */
    private String jumpUrl;

    /**
     * 通知等级
     */
    private Integer level;

    /**
     * 通知时间
     */
    private Timestamp notifyTime;

}
