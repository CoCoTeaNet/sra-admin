package com.sraapp.cms.param.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * 新增文章参数
 *
 * @author CoCoTea
 * @date 2022-7-24 16:01:22
 */
@ApiModel("新增文章参数")
public class ArticleAddParam implements Serializable {
    private static final long serialVersionUID = 1113969990552647916L;

    @ApiModelProperty(value = "文章标题",required = true)
    @NotBlank(message = "标题为空")
    private String title;

    @ApiModelProperty(value = "文章内容", required = true)
    @NotBlank(message = "内容为空")
    private String content;

    @ApiModelProperty("文章标签")
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
}
