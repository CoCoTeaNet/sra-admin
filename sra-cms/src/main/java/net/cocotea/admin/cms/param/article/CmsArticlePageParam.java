package net.cocotea.admin.cms.param.article;

import net.cocotea.admin.cms.vo.CmsArticleVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

public class CmsArticlePageParam extends Page<CmsArticleVO> implements Serializable {
    private static final long serialVersionUID = 1L;

    private CmsArticleVO article;

    public CmsArticleVO getArticle() {
        return article;
    }

    public CmsArticlePageParam setArticle(CmsArticleVO article) {
        this.article = article;
        return this;
    }
}
