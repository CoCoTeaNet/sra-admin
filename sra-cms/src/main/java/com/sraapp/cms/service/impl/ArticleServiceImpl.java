package com.sraapp.cms.service.impl;

import cn.hutool.core.convert.Convert;
import com.sraapp.cms.entity.CmsArticle;
import com.sraapp.cms.param.ArticleAddParam;
import com.sraapp.cms.param.ArticlePageParam;
import com.sraapp.cms.param.ArticleUpdateParam;
import com.sraapp.cms.service.IArticleService;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.model.BusinessException;
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
        CmsArticle article = Convert.convert(CmsArticle.class, param);
        Object save = sqlToyLazyDao.save(article);
        // 关联标签
        return true;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        List<CmsArticle> articleList = new ArrayList<>();
        for (String id : idList) {
            CmsArticle article = new CmsArticle();
            article.setId(id);
            article.setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
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
        article.setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long update = sqlToyLazyDao.update(article);
        return update > 0;
    }
}
