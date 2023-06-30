package net.cocotea.admin.system.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SysVersionVO implements Serializable {
    private static final long serialVersionUID = 7698110780485543494L;
    private String id;

    /**
     * 更新版本号
     */
    private String updateNo;

    /**
     * 版本更新描述
     */
    private String updateDesc;

    /**
     * 系统平台名称
     */
    private String platformName;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    public String getId() {
        return this.id;
    }

    public SysVersionVO setId(String id) {
        this.id=id;
        return this;
    }

    public String getUpdateNo() {
        return this.updateNo;
    }

    public SysVersionVO setUpdateNo(String updateNo) {
        this.updateNo=updateNo;
        return this;
    }

    public String getUpdateDesc() {
        return this.updateDesc;
    }

    public SysVersionVO setUpdateDesc(String updateDesc) {
        this.updateDesc=updateDesc;
        return this;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public SysVersionVO setPlatformName(String platformName) {
        this.platformName=platformName;
        return this;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public SysVersionVO setDownloadUrl(String downloadUrl) {
        this.downloadUrl=downloadUrl;
        return this;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public SysVersionVO setCreateBy(String createBy) {
        this.createBy=createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public SysVersionVO setCreateTime(LocalDateTime createTime) {
        this.createTime=createTime;
        return this;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public SysVersionVO setUpdateBy(String updateBy) {
        this.updateBy=updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public SysVersionVO setUpdateTime(LocalDateTime updateTime) {
        this.updateTime=updateTime;
        return this;
    }


    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
