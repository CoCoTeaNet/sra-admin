package com.sraapp.cms.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import org.sagacity.sqltoy.config.annotation.Entity;
import org.sagacity.sqltoy.config.annotation.Id;
import org.sagacity.sqltoy.config.annotation.Column;

/**
 * @author CoCoTea
 * Table: cms_comment,Remark:评论主表
 */
@Entity(tableName="cms_comment")
public class CmsComment implements Serializable {
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
    @Column(name="PARENT_ID",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String parentId;

    /**
     * 回复用户ID
     */
    @Column(name="REPLY_USER_ID",length=32L,type=java.sql.Types.VARCHAR)
    private String replyUserId;

    /**
     * 回复内容
     */
    @Column(name="CONTENT",length=500L,type=java.sql.Types.VARCHAR,nullable=false)
    private String content;

    /**
     * 回复类型;0文章 1用户
     */
    @Column(name="REPLY_TYPE",length=1L,type=java.sql.Types.CHAR)
    private String replyType;

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
     * 数据状态
     */
    @Column(name="data_state",type=java.sql.Types.INTEGER,nullable=false)
    private Integer dataState;

    /**
     * 文章id
     */
    @Column(name="article_id",length=32L,type=java.sql.Types.VARCHAR,nullable=false)
    private String articleId;

    /**
     * 评论类型：1文章 2反馈
     */
    @Column(name="comment_type",type=java.sql.Types.INTEGER,nullable=false)
    private Integer commentType;


    public String getId() {
        return this.id;
    }

    public CmsComment setId(String id) {
        this.id=id;
        return this;
    }

    public String getParentId() {
        return this.parentId;
    }

    public CmsComment setParentId(String parentId) {
        this.parentId=parentId;
        return this;
    }

    public String getReplyUserId() {
        return this.replyUserId;
    }

    public CmsComment setReplyUserId(String replyUserId) {
        this.replyUserId=replyUserId;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public CmsComment setContent(String content) {
        this.content=content;
        return this;
    }

    public String getReplyType() {
        return this.replyType;
    }

    public CmsComment setReplyType(String replyType) {
        this.replyType=replyType;
        return this;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public CmsComment setCreateBy(String createBy) {
        this.createBy=createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public CmsComment setCreateTime(LocalDateTime createTime) {
        this.createTime=createTime;
        return this;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public CmsComment setUpdateBy(String updateBy) {
        this.updateBy=updateBy;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public CmsComment setUpdateTime(LocalDateTime updateTime) {
        this.updateTime=updateTime;
        return this;
    }

    public String getDeleteStatus() {
        return this.deleteStatus;
    }

    public CmsComment setDeleteStatus(String deleteStatus) {
        this.deleteStatus=deleteStatus;
        return this;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public CmsComment setRevision(Integer revision) {
        this.revision=revision;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public CmsComment setCreateDate(LocalDateTime createDate) {
        this.createDate=createDate;
        return this;
    }

    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }

    public CmsComment setUpdateDate(LocalDateTime updateDate) {
        this.updateDate=updateDate;
        return this;
    }

    public Integer getDataState() {
        return this.dataState;
    }

    public CmsComment setDataState(Integer dataState) {
        this.dataState=dataState;
        return this;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public CmsComment setArticleId(String articleId) {
        this.articleId=articleId;
        return this;
    }

    public Integer getCommentType() {
        return this.commentType;
    }

    public CmsComment setCommentType(Integer commentType) {
        this.commentType=commentType;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder columnsBuffer = new StringBuilder();
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("parentId=").append(getParentId()).append("\n");
        columnsBuffer.append("replyUserId=").append(getReplyUserId()).append("\n");
        columnsBuffer.append("content=").append(getContent()).append("\n");
        columnsBuffer.append("replyType=").append(getReplyType()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createTime=").append(getCreateTime()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateTime=").append(getUpdateTime()).append("\n");
        columnsBuffer.append("deleteStatus=").append(getDeleteStatus()).append("\n");
        columnsBuffer.append("revision=").append(getRevision()).append("\n");
        columnsBuffer.append("id=").append(getId()).append("\n");
        columnsBuffer.append("parentId=").append(getParentId()).append("\n");
        columnsBuffer.append("content=").append(getContent()).append("\n");
        columnsBuffer.append("createBy=").append(getCreateBy()).append("\n");
        columnsBuffer.append("createDate=").append(getCreateDate()).append("\n");
        columnsBuffer.append("updateBy=").append(getUpdateBy()).append("\n");
        columnsBuffer.append("updateDate=").append(getUpdateDate()).append("\n");
        columnsBuffer.append("dataState=").append(getDataState()).append("\n");
        columnsBuffer.append("articleId=").append(getArticleId()).append("\n");
        columnsBuffer.append("commentType=").append(getCommentType()).append("\n");
        return columnsBuffer.toString();
    }
}
