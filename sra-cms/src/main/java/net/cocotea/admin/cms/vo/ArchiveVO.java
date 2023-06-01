package net.cocotea.admin.cms.vo;

import java.io.Serializable;

/**
 * @date 2022-8-17 22:10:43
 * @author CoCoTea
 */
public class ArchiveVO implements Serializable {
    private static final long serialVersionUID = 3146995875144267718L;

    private String day;
    private Integer total;

    public String getDay() {
        return day;
    }

    public ArchiveVO setDay(String day) {
        this.day = day;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public ArchiveVO setTotal(Integer total) {
        this.total = total;
        return this;
    }
}
