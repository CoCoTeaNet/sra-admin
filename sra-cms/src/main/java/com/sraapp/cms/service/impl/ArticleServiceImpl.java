package com.sraapp.cms.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.sraapp.cms.entity.CmsArticle;
import com.sraapp.cms.param.article.ArticleAddParam;
import com.sraapp.cms.param.article.ArticlePageParam;
import com.sraapp.cms.param.article.ArticleUpdateParam;
import com.sraapp.cms.service.IArticleService;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.cms.vo.TagVo;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.enums.PublishStatusEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.common.util.StringUtils;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CoCoTea
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(ArticleAddParam param) throws BusinessException {
        StringBuilder tagBuilder = new StringBuilder();
        param.getTags().forEach(item -> tagBuilder.append(item).append(StringUtils.COMMA));
        CmsArticle article = Convert.convert(CmsArticle.class, param);
        article.setTags(tagBuilder.substring(0, tagBuilder.length() - 1));
        article.setPublishStatus(PublishStatusEnum.NORMAL.getCode());
        Object save = sqlToyLazyDao.save(article);
        return StrUtil.isNotBlank(save.toString());
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        List<CmsArticle> articleList = new ArrayList<>();
        for (String id : idList) {
            CmsArticle article = new CmsArticle();
            article.setId(id);
            article.setDeleteStatus(Integer.parseInt(DeleteStatusEnum.DELETE.getCode()));
            articleList.add(article);
        }
        Long updateAll = sqlToyLazyDao.updateAll(articleList);
        return updateAll > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(ArticleUpdateParam param) throws BusinessException {
        CmsArticle article = Convert.convert(CmsArticle.class, param);
        Long update = sqlToyLazyDao.update(article);
        return update > 0;
    }

    @Override
    public Page<ArticleVo> listByPage(ArticlePageParam param) throws BusinessException {
        Page<ArticleVo> page = sqlToyLazyDao.findPageBySql(param, "cms_article_findByPageParam", param.getArticleVo());
        return page;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        CmsArticle article = new CmsArticle();
        article.setId(id);
        article.setDeleteStatus(Integer.parseInt(DeleteStatusEnum.DELETE.getCode()));
        Long update = sqlToyLazyDao.update(article);
        return update > 0;
    }

    @Override
    public CmsArticle detail(String id) {
        CmsArticle article = sqlToyLazyDao.loadBySql("cms_article_findByEntityParam", new CmsArticle().setId(id));
        return article;
    }

    @Override
    public List<ArticleVo> findByCommentNumDesc() {
        return null;
    }

    @Override
    public List<ArticleVo> findByTimeDesc() {
        return null;
    }

    @Override
    public List<ArticleVo> findByArchiveList() {
        return null;
    }

    @Override
    public List<TagVo> findHotTagList() {
        return null;
    }
}
