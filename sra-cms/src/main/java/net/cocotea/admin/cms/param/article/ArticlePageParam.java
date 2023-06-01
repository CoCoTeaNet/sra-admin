package net.cocotea.admin.cms.param.article;

import net.cocotea.admin.cms.vo.ArticleVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

public class ArticlePageParam extends Page<ArticleVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArticleVO articleVo;

    public ArticleVO getArticleVo() {
        return articleVo;
    }

    public void setArticleVo(ArticleVO articleVo) {
        this.articleVo = articleVo;
    }
}
