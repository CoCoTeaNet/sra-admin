package net.cocotea.cms.service.impl;

import net.cocotea.cms.entity.CmsComment;
import net.cocotea.cms.param.comment.CommentAddParam;
import net.cocotea.cms.param.comment.CommentPageParam;
import net.cocotea.cms.param.comment.CommentUpdateParam;
import net.cocotea.cms.service.ICommentService;
import net.cocotea.cms.vo.CommentVo;
import net.cocotea.common.enums.DeleteStatusEnum;
import net.cocotea.common.enums.ReplyTypeEnum;
import net.cocotea.common.model.BusinessException;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(CommentAddParam param) throws BusinessException {
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
    public boolean update(CommentUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<CommentVo> listByPage(CommentPageParam param) throws BusinessException {
        Page<CommentVo> page = sqlToyLazyDao.findPageBySql(param, "cms_comment_findByPageParam", param.getCommentVo());
        return page;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return false;
    }

    @Override
    public List<CommentVo> listByArticleId(String articleId) {
        List<CommentVo> list = sqlToyLazyDao.findBySql("cms_comment_findByEntityParam", new CommentVo().setArticleId(articleId));
        return list;
    }
}
