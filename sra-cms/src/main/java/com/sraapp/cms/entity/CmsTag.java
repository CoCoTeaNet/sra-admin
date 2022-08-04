package com.sraapp.cms.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author CoCoTea
 * Table: cms_tag,Remark:标签主表
 * @date 2022-8-3 17:57:04
 */
@Entity(tableName="cms_tag")
public class CmsTag implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String id;

    /**
     * 父级ID
     */
    @Column(name="PARENT_ID",length=32L,type=java.sql.Types.VARCHAR)
    private String parentId;

    /**
     * 标签名称
     */
    @Column(name="TAG_NAME",length=50L,type=java.sql.Types.VARCHAR)
    private String tagName;

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
    @Column(name="UPDATE_BY",length=32L,type=java.sql.Types.VARCHAR)
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name="UPDATE_TIME",type=java.sql.Types.DATE)
    private LocalDateTime updateTime;

    /**
     * 删除状态;0删除 1未删除
     */
    @Column(name="DELETE_STATUS",length=1L,type=java.sql.Types.CHAR,nullable=false)
    private String deleteStatus;

    /**
     * 乐观锁
     */
    @Column(name="REVISION",type=java.sql.Types.INTEGER)
    private Integer revision;

    /**
     * 标签名称
     */
    @Column(name="name",length=16L,type=java.sql.Types.VARCHAR,nullable=false)
    private String name;

    /**
     * 创建时间
     */
    @Column(name="create_date",type=java.sql.Types.DATE,nullable=false)
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @Column(name="update_date",type=java.sql.Types.DATE)
    private LocalDateTime updateDate;

    /**
     * 数据状态：1正常 2失效
     */
    @Column(name="data_state",type=java.sql.Types.INTEGER)
    private Integer dataState;

    public String getTagName() {
        return this.tagName;
    }

    public CmsTag setTagName(String tagName) {
        this.tagName=tagName;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public CmsTag setCreateTime(LocalDateTime createTime) {
        this.createTime=createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public CmsTag setUpdateTime(LocalDateTime updateTime) {
        this.updateTime=updateTime;
        return this;
    }

    public String getDeleteStatus() {
        return this.deleteStatus;
    }

    public CmsTag setDeleteStatus(String deleteStatus) {
        this.deleteStatus=deleteStatus;
        return this;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public CmsTag setRevision(Integer revision) {
        this.revision=revision;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public CmsTag setId(String id) {
        this.id=id;
        return this;
    }

    public String getParentId() {
        return this.parentId;
    }

    public CmsTag setParentId(String parentId) {
        this.parentId=parentId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public CmsTag setName(String name) {
        this.name=name;
        return this;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public CmsTag setCreateBy(String createBy) {
        this.createBy=createBy;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public CmsTag setCreateDate(LocalDateTime createDate) {
        this.createDate=createDate;
        return this;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public CmsTag setUpdateBy(String updateBy) {
        this.updateBy=updateBy;
        return this;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public CmsTag setUpdateDate(LocalDateTime updateDate) {
        this.updateDate=updateDate;
        return this;
    }

    public Integer getDataState() {
        return this.dataState;
    }

    public CmsTag setDataState(Integer dataState) {
        this.dataState=dataState;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("parentId=").append(getParentId()).append("\n");
        columnsBuffer.append("tagName=").append(getTagName()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
        columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
        columnsBuffer.append("revision=").append(getRevision()).append("\n");
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("parentId=").append(getParentId()).append("\n");
        columnsBuffer.append("name=").append(getName()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createDate=").append(getCreateDate()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateDate=").append(getUpdateDate()).append("\n");
        columnsBuffer.append("dataState=").append(getDataState()).append("\n");
        return columnsBuffer.toString();
    }
}
