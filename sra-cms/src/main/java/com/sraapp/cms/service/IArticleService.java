package com.sraapp.cms.service;

import com.sraapp.cms.entity.CmsArticle;
import com.sraapp.cms.param.article.ArticleAddParam;
import com.sraapp.cms.param.article.ArticlePageParam;
import com.sraapp.cms.param.article.ArticleUpdateParam;
import com.sraapp.cms.vo.ArchiveVo;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.cms.vo.TagVo;
import com.sraapp.common.service.IBaseService;
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
