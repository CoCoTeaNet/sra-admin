package net.cocotea.admin.cms.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ArticleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 简介
     */
    private String summary;

    /**
     * 发布状态;1正常 2审核中 3审核不通过 4冻结 5保存
     */
    private Integer publishStatus;

    /**
     * 标签
     */
    private String tags;

    private List<String> tagList;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    private String cover;

    public String getCover() {
        return cover;
    }

    public ArticleVO setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ArticleVO setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public ArticleVO setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public ArticleVO setTagList(List<String> tagList) {
        this.tagList = tagList;
        return this;
    }

    public String getId() {
        return id;
    }

    public ArticleVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleVO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ArticleVO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public ArticleVO setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public ArticleVO setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public ArticleVO setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public ArticleVO setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ArticleVO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
}
