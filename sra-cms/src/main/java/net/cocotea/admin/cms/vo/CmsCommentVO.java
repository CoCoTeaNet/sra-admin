package net.cocotea.admin.cms.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CmsCommentVO implements Serializable {

    private static final long serialVersionUID = 261866700727263560L;
    /**
     * 主键id
     */
    private String id;

    /**
     * 父级ID
     */
    private String parentId;

    /**
     * 回复用户ID
     */
    private String replyUserId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复类型;0文章 1用户
     */
    private Integer replyType;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 评论类型：1文章 2反馈
     */
    private Integer commentType;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public CmsCommentVO setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public CmsCommentVO setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getId() {
        return id;
    }

    public CmsCommentVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public CmsCommentVO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getReplyUserId() {
        return replyUserId;
    }

    public CmsCommentVO setReplyUserId(String replyUserId) {
        this.replyUserId = replyUserId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CmsCommentVO setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public CmsCommentVO setReplyType(Integer replyType) {
        this.replyType = replyType;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public CmsCommentVO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public CmsCommentVO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getArticleId() {
        return articleId;
    }

    public CmsCommentVO setArticleId(String articleId) {
        this.articleId = articleId;
        return this;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public CmsCommentVO setCommentType(Integer commentType) {
        this.commentType = commentType;
        return this;
    }
}
