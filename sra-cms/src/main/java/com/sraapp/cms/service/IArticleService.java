package com.sraapp.cms.service;

import com.sraapp.cms.param.ArticleAddParam;
import com.sraapp.cms.param.ArticlePageParam;
import com.sraapp.cms.param.ArticleUpdateParam;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

/**
 * @author CoCoTea
 */
public interface IArticleService extends IBaseService<Page<ArticleVo>, ArticlePageParam, ArticleAddParam, ArticleUpdateParam> {
}
