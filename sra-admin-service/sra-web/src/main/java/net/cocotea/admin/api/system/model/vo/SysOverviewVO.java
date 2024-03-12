package net.cocotea.admin.api.system.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 系统数据概览
 *
 * @author CoCoTea
 */
@Data
@Accessors(chain = true)
public class SysOverviewVO {

    /**
     * 标题
     */
    private String title;

    /**
     * 数量
     */
    private Long count;

}
