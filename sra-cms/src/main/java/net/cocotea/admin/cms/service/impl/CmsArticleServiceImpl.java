package net.cocotea.admin.cms.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import net.cocotea.admin.cms.entity.CmsArticle;
import net.cocotea.admin.cms.param.article.CmsArticleAddParam;
import net.cocotea.admin.cms.param.article.CmsArticlePageParam;
import net.cocotea.admin.cms.param.article.CmsArticleUpdateParam;
import net.cocotea.admin.cms.service.CmsArticleService;
import net.cocotea.admin.cms.vo.CmsArchiveVO;
import net.cocotea.admin.cms.vo.CmsArticleVO;
import net.cocotea.admin.cms.vo.CmsTagVO;
import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.enums.PublishStatusEnum;
import net.cocotea.admin.common.model.BusinessException;
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
public class CmsArticleServiceImpl implements CmsArticleService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(CmsArticleAddParam param) throws BusinessException {
        CmsArticle article = Convert.convert(CmsArticle.class, param);
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
            article.setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            articleList.add(article);
        }
        Long updateAll = sqlToyLazyDao.updateAll(articleList);
        return updateAll > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(CmsArticleUpdateParam param) throws BusinessException {
        CmsArticle article = Convert.convert(CmsArticle.class, param);
        Long update = sqlToyLazyDao.update(article);
        return update > 0;
    }

    @Override
    public Page<CmsArticleVO> listByPage(CmsArticlePageParam param) throws BusinessException {
        Page<CmsArticleVO> page = sqlToyLazyDao.findPageBySql(param, "cms_article_findByPageParam", param.getArticle());
        page.getRows().forEach(articleVo -> {
            JSONArray parseArray = JSONUtil.parseArray(articleVo.getTags());
            articleVo.setTagList(parseArray.toList(String.class));
        });
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

    @Override
    public CmsArticleVO detail(String id) {
        CmsArticleVO articleVo = sqlToyLazyDao.loadBySql("cms_article_findByEntityParam", new CmsArticleVO().setId(id));
        JSONArray parseArray = JSONUtil.parseArray(articleVo.getTags());
        articleVo.setTagList(parseArray.toList(String.class));
        return articleVo;
    }

    @Override
    public List<CmsTagVO> findTags(List<CmsArticleVO> articleVOList) {
        List<String> tags = new ArrayList<>();
        final String[] colors = {"bg-primary", "bg-secondary", "bg-success", "bg-danger", "bg-warning text-dark", "bg-info text-dark", "bg-light text-dark", "bg-dark"};
        if (articleVOList == null) articleVOList = findByTimeDesc();
        articleVOList.forEach(item -> {
            JSONArray array = JSONUtil.parseArray(item.getTags());
            tags.addAll(array.toList(String.class));
        });
        List<CmsTagVO> vos = new ArrayList<>();
        tags.stream().distinct().forEach(tag -> vos.add(new CmsTagVO().setTagName(tag).setColor(colors[RandomUtil.randomInt(colors.length - 1)])));
        return vos;
    }

    @Override
    public List<CmsArticleVO> findByTimeDesc() {
        String sql = "select ID, TITLE, TAGS, COVER, SUMMARY, CREATE_TIME from cms_article where DELETE_STATUS = 1 order by CREATE_TIME desc, UPDATE_TIME desc limit 15";
        List<CmsArticleVO> list = sqlToyLazyDao.findBySql(sql, new CmsArticleVO());
        list.forEach(articleVo -> {
            if (StrUtil.isBlank(articleVo.getCover())) {
                articleVo.setCover("/default/default-cover.jpg");
            }
        });
        return list;
    }

    @Override
    public List<CmsArchiveVO> findByArchiveList() {
        List<CmsArchiveVO> archiveVOs = sqlToyLazyDao.findBySql("cms_article_findByArchiveList", new CmsArchiveVO());
        return archiveVOs;
    }
}
