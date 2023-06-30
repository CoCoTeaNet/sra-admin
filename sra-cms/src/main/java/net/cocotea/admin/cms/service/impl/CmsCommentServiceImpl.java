package net.cocotea.admin.cms.service.impl;

import net.cocotea.admin.cms.entity.CmsComment;
import net.cocotea.admin.cms.param.comment.CmsCommentAddParam;
import net.cocotea.admin.cms.param.comment.CmsCommentPageParam;
import net.cocotea.admin.cms.param.comment.CmsCommentUpdateParam;
import net.cocotea.admin.cms.service.CmsCommentService;
import net.cocotea.admin.cms.vo.CmsCommentVO;
import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.enums.ReplyTypeEnum;
import net.cocotea.admin.common.model.BusinessException;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CmsCommentServiceImpl implements CmsCommentService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(CmsCommentAddParam param) throws BusinessException {
        CmsComment comment = new CmsComment();
        comment.setParentId(String.valueOf(0))
                .setArticleId(param.getArticleId())
                .setDeleteStatus(DeleteStatusEnum.NOT_DELETE.getCode())
                .setCreateTime(LocalDateTime.now())
                .setContent(param.getContent())
                .setCreateBy(param.getEmail())
                .setReplyType(ReplyTypeEnum.ARTICLE.getCode());
        return sqlToyLazyDao.save(comment) != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        List<CmsComment> comments = new ArrayList<>(idList.size());
        idList.forEach(item -> comments.add(new CmsComment().setId(item).setDeleteStatus(DeleteStatusEnum.DELETE.getCode())));
        Long all = sqlToyLazyDao.updateAll(comments);
        return all > 0;
    }

    @Override
    public boolean update(CmsCommentUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<CmsCommentVO> listByPage(CmsCommentPageParam param) throws BusinessException {
        Page<CmsCommentVO> page = sqlToyLazyDao.findPageBySql(param, "cms_comment_findByPageParam", param.getComment());
        return page;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return false;
    }

    @Override
    public List<CmsCommentVO> listByArticleId(String articleId) {
        List<CmsCommentVO> list = sqlToyLazyDao.findBySql("cms_comment_findByEntityParam", new CmsCommentVO().setArticleId(articleId));
        return list;
    }
}
