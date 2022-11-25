package net.cocotea.admin.system.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author CoCoTea
 * Table: sys_version,Remark:系统版本更新记录表
 */
@Entity(tableName="sys_version")
public class Version implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String id;

    /**
     * 更新版本号
     */
    @Column(name="UPDATE_NO",length=20L,type=java.sql.Types.VARCHAR)
    private String updateNo;

    /**
     * 版本更新描述
     */
    @Column(name="UPDATE_DESC",length=900L,type=java.sql.Types.VARCHAR)
    private String updateDesc;

    /**
     * 系统平台名称
     */
    @Column(name="PLATFORM_NAME",length=10L,type=java.sql.Types.VARCHAR)
    private String platformName;

    /**
     * 下载地址
     */
    @Column(name="DOWNLOAD_URL",length=200L,type=java.sql.Types.VARCHAR)
    private String downloadUrl;

    /**
     * 创建人
     */
    @Column(name="CREATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name="CREATE_TIME",type=java.sql.Types.DATE,nullable=false)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @Column(name="UPDATE_BY",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name="UPDATE_TIME",type=java.sql.Types.DATE,nullable=false)
    private LocalDateTime updateTime;

    public String getId() {
        return id;
    }

    public Version setId(String id) {
        this.id = id;
        return this;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public Version setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
        return this;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public Version setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
        return this;
    }

    public String getPlatformName() {
        return platformName;
    }

    public Version setPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Version setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Version setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Version setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Version setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Version setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("updateNo=").append(getUpdateNo()).append("\n");
        columnsBuffer.append("updateDesc=").append(getUpdateDesc()).append("\n");
        columnsBuffer.append("platformName=").append(getPlatformName()).append("\n");
        columnsBuffer.append("downloadUrl=").append(getDownloadUrl()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
        return columnsBuffer.toString();
    }
}