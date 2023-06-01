package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.ArchiveVO;
import net.cocotea.admin.cms.vo.ArticleVO;
import net.cocotea.admin.cms.vo.TagVO;
import net.cocotea.admin.cms.param.article.ArticleAddParam;
import net.cocotea.admin.cms.param.article.ArticlePageParam;
import net.cocotea.admin.cms.param.article.ArticleUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @author CoCoTea
 */
public interface IArticleService extends IBaseService<Page<ArticleVO>, ArticlePageParam, ArticleAddParam, ArticleUpdateParam> {
    ArticleVO detail(String id);

    List<TagVO> findTags(List<ArticleVO> articleVOList);

    List<ArticleVO> findByTimeDesc();

    List<ArchiveVO> findByArchiveList();
}
