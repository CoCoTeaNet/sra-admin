package net.cocotea.admin.cms.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author CoCoTea
 * Table: cms_article,Remark:文章主表
 */
@Entity(tableName="cms_article")
public class CmsArticle implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id(strategy="generator",generator="org.sagacity.sqltoy.plugins.id.impl.UUIDGenerator")
    @Column(name="ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String id;

    /**
     * 标题
     */
    @Column(name="TITLE",length=100L,type=java.sql.Types.VARCHAR,nullable=false)
    private String title;

    /**
     * 封面
     */
    @Column(name="COVER",length=200L,type=java.sql.Types.VARCHAR,nullable=false)
    private String cover;

    /**
     * 内容
     */
    @Column(name="CONTENT",length=65535L,type=java.sql.Types.VARCHAR,nullable=false)
    private String content;

    /**
     * 简介
     */
    @Column(name="SUMMARY",length=255L,type=java.sql.Types.VARCHAR)
    private String summary;

    /**
     * 发布状态;1正常 2审核中 3审核不通过 4冻结 5保存
     */
    @Column(name="PUBLISH_STATUS",length=1L,type=java.sql.Types.CHAR)
    private Integer publishStatus;

    @Column(name="TAGS",length=255L,type=java.sql.Types.VARCHAR)
    private String tags;

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
    private Integer deleteStatus;

    /**
     * 乐观锁
     */
    @Column(name="REVISION",type=java.sql.Types.INTEGER)
    private Integer revision;


    public String getId() {
        return this.id;
    }

    public CmsArticle setId(String id) {
        this.id=id;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public CmsArticle setTitle(String title) {
        this.title=title;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public CmsArticle setContent(String content) {
        this.content=content;
        return this;
    }

    public String getSummary() {
        return this.summary;
    }

    public CmsArticle setSummary(String summary) {
        this.summary=summary;
        return this;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public CmsArticle setCreateBy(String createBy) {
        this.createBy=createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public CmsArticle setCreateTime(LocalDateTime createTime) {
        this.createTime=createTime;
        return this;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public CmsArticle setUpdateBy(String updateBy) {
        this.updateBy=updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public CmsArticle setUpdateTime(LocalDateTime updateTime) {
        this.updateTime=updateTime;
        return this;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public CmsArticle setRevision(Integer revision) {
        this.revision=revision;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCover() {
        return cover;
    }

    public CmsArticle setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("title=").append(getTitle()).append("\n");
        columnsBuffer.append("content=").append(getContent()).append("\n");
        columnsBuffer.append("summary=").append(getSummary()).append("\n");
        columnsBuffer.append("publishStatus=").append(getPublishStatus()).append("\n");
        columnsBuffer.append("tags=").append(getTags()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
        columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
        columnsBuffer.append("revision=").append(getRevision()).append("\n");
        return columnsBuffer.toString();
    }
}