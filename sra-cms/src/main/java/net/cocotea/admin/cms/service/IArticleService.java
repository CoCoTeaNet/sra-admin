package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.ArchiveVo;
import net.cocotea.admin.cms.vo.ArticleVo;
import net.cocotea.admin.cms.vo.TagVo;
import net.cocotea.admin.cms.param.article.ArticleAddParam;
import net.cocotea.admin.cms.param.article.ArticlePageParam;
import net.cocotea.admin.cms.param.article.ArticleUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
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
