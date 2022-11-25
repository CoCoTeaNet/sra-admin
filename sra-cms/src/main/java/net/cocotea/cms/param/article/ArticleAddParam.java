package net.cocotea.cms.param.article;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 新增文章参数
 *
 * @author CoCoTea
 * @date 2022-7-24 16:01:22
 */
public class ArticleAddParam implements Serializable {
    private static final long serialVersionUID = 1113969990552647916L;

    @NotBlank(message = "标题为空")
    private String title;

    @NotBlank(message = "内容为空")
    private String content;

    private String summary;

    private List<String> tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public ArticleAddParam setSummary(String summary) {
        this.summary = summary;
        return this;
    }
}
