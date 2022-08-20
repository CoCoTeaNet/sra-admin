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
                .setReplyType(ReplyTypeEnum.ARTICLE.getCode())
                .setId(IdUtil.fastSimpleUUID());
        String sql =
                "insert into cms_comment(ID,CREATE_BY,REPLY_TYPE,CONTENT,PARENT_ID,ARTICLE_ID,DELETE_STATUS,CREATE_TIME)" +
                        " value(:id,:createBy,:replyType,:content,:parentId,:articleId,:deleteStatus,:createTime)";
        Object save = sqlToyLazyDao.executeSql(sql, comment);
        return StrUtil.isNotBlank(save.toString());
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        return false;
    }

    @Override
    public boolean update(CommentUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public Page<CommentVo> listByPage(CommentPageParam param) throws BusinessException {
        return null;
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
