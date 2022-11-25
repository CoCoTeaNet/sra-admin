package net.cocotea.cms.service;

import net.cocotea.cms.param.article.ArticleAddParam;
import net.cocotea.cms.param.article.ArticlePageParam;
import net.cocotea.cms.param.article.ArticleUpdateParam;
import net.cocotea.cms.vo.ArchiveVo;
import net.cocotea.cms.vo.ArticleVo;
import net.cocotea.cms.vo.TagVo;
import net.cocotea.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @author CoCoTea
 */
public interface IArticleService extends IBaseService<Page<ArticleVo>, ArticlePageParam, ArticleAddParam, ArticleUpdateParam> {
    ArticleVo detail(String id);

    List<TagVo> findTags(List<ArticleVo> articleVoList);

    List<ArticleVo> findByTimeDesc();

    List<ArchiveVo> findByArchiveList();
}
