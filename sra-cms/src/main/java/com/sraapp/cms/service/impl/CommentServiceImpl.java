package com.sraapp.cms.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.sraapp.cms.entity.CmsComment;
import com.sraapp.cms.param.comment.CommentAddParam;
import com.sraapp.cms.param.comment.CommentPageParam;
import com.sraapp.cms.param.comment.CommentUpdateParam;
import com.sraapp.cms.service.ICommentService;
import com.sraapp.cms.vo.CommentVo;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.enums.ReplyTypeEnum;
import com.sraapp.common.model.BusinessException;
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
