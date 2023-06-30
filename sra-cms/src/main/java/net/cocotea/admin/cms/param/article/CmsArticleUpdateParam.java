package net.cocotea.admin.cms.param.article;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 更新文章参数
 *
 * @author CoCoTea
 * @date 2022-7-24 16:01:22
 */
public class CmsArticleUpdateParam implements Serializable {

    private static final long serialVersionUID = -8951611583471320888L;

    @NotBlank(message = "文章id为空")
    private String id;

    @NotBlank(message = "标题为空")
    private String title;

    @NotBlank(message = "内容为空")
    private String content;

    private String summary;

    private List<String> tags;

    private String cover;

    public String getCover() {
        return cover;
    }

    public CmsArticleUpdateParam setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getId() {
        return id;
    }

    public CmsArticleUpdateParam setId(String id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public CmsArticleUpdateParam setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CmsArticleUpdateParam setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CmsArticleUpdateParam setContent(String content) {
        this.content = content;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public CmsArticleUpdateParam setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }
}
