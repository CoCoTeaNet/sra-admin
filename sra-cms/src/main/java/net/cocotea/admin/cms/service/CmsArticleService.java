package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.CmsArchiveVO;
import net.cocotea.admin.cms.vo.CmsArticleVO;
import net.cocotea.admin.cms.vo.CmsTagVO;
import net.cocotea.admin.cms.param.article.CmsArticleAddParam;
import net.cocotea.admin.cms.param.article.CmsArticlePageParam;
import net.cocotea.admin.cms.param.article.CmsArticleUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @author CoCoTea
 */
public interface CmsArticleService extends IBaseService<Page<CmsArticleVO>, CmsArticlePageParam, CmsArticleAddParam, CmsArticleUpdateParam> {
    CmsArticleVO detail(String id);

    List<CmsTagVO> findTags(List<CmsArticleVO> articleVOList);

    List<CmsArticleVO> findByTimeDesc();

    List<CmsArchiveVO> findByArchiveList();
}
