package net.cocotea.admin.cms.param.article;

import net.cocotea.admin.cms.vo.ArticleVo;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

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
