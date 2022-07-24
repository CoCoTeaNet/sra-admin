package com.sraapp.cms.service.impl;

import com.sraapp.cms.param.ArticleAddParam;
import com.sraapp.cms.param.ArticlePageParam;
import com.sraapp.cms.param.ArticleUpdateParam;
import com.sraapp.cms.service.IArticleService;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CoCoTea
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Override
    public boolean add(ArticleAddParam param) throws BusinessException {
        return false;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        return false;
    }

    @Override
    public boolean update(ArticleUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<ArticleVo> listByPage(ArticlePageParam param) throws BusinessException {
        return null;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return false;
    }
}
