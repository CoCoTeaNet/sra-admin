package net.cocotea.admin.cms.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import net.cocotea.admin.cms.entity.CmsArticle;
import net.cocotea.admin.cms.param.article.ArticleAddParam;
import net.cocotea.admin.cms.param.article.ArticlePageParam;
import net.cocotea.admin.cms.param.article.ArticleUpdateParam;
import net.cocotea.admin.cms.service.IArticleService;
import net.cocotea.admin.cms.vo.ArchiveVO;
import net.cocotea.admin.cms.vo.ArticleVO;
import net.cocotea.admin.cms.vo.TagVO;
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
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(ArticleAddParam param) throws BusinessException {
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
    public boolean update(ArticleUpdateParam param) throws BusinessException {
        CmsArticle article = Convert.convert(CmsArticle.class, param);
        Long update = sqlToyLazyDao.update(article);
        return update > 0;
    }

    @Override
    public Page<ArticleVO> listByPage(ArticlePageParam param) throws BusinessException {
        Page<ArticleVO> page = sqlToyLazyDao.findPageBySql(param, "cms_article_findByPageParam", param.getArticleVo());
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
    public ArticleVO detail(String id) {
        ArticleVO articleVo = sqlToyLazyDao.loadBySql("cms_article_findByEntityParam", new ArticleVO().setId(id));
        JSONArray parseArray = JSONUtil.parseArray(articleVo.getTags());
        articleVo.setTagList(parseArray.toList(String.class));
        return articleVo;
    }

    @Override
    public List<TagVO> findTags(List<ArticleVO> articleVOList) {
        List<String> tags = new ArrayList<>();
        final String[] colors = {"bg-primary", "bg-secondary", "bg-success", "bg-danger", "bg-warning text-dark", "bg-info text-dark", "bg-light text-dark", "bg-dark"};
        if (articleVOList == null) articleVOList = findByTimeDesc();
        articleVOList.forEach(item -> {
            JSONArray array = JSONUtil.parseArray(item.getTags());
            tags.addAll(array.toList(String.class));
        });
        List<TagVO> vos = new ArrayList<>();
        tags.stream().distinct().forEach(tag -> vos.add(new TagVO().setTagName(tag).setColor(colors[RandomUtil.randomInt(colors.length - 1)])));
        return vos;
    }

    @Override
    public List<ArticleVO> findByTimeDesc() {
        String sql = "select ID, TITLE, TAGS, COVER, SUMMARY, CREATE_TIME from cms_article where DELETE_STATUS = 1 order by CREATE_TIME desc, UPDATE_TIME desc limit 15";
        List<ArticleVO> list = sqlToyLazyDao.findBySql(sql, new ArticleVO());
        list.forEach(articleVo -> {
            if (StrUtil.isBlank(articleVo.getCover())) {
                articleVo.setCover("/default/default-cover.jpg");
            }
        });
        return list;
    }

    @Override
    public List<ArchiveVO> findByArchiveList() {
        List<ArchiveVO> archiveVOs = sqlToyLazyDao.findBySql("cms_article_findByArchiveList", new ArchiveVO());
        return archiveVOs;
    }
}
