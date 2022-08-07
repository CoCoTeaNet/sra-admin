package com.sraapp.cms.param;

import com.sraapp.cms.vo.ArticleVo;
import io.swagger.annotations.ApiModel;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

@ApiModel("文章分页参数")
public class ArticlePageParam extends Page<ArticleVo> implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArticleVo articleVo;

    public ArticleVo getArticleVo() {
        return articleVo;
    }

    public void setArticleVo(ArticleVo articleVo) {
        this.articleVo = articleVo;
    }
}
