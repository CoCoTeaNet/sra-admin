package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.CommentVo;
import net.cocotea.admin.cms.param.comment.CommentAddParam;
import net.cocotea.admin.cms.param.comment.CommentPageParam;
import net.cocotea.admin.cms.param.comment.CommentUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public interface ICommentService extends IBaseService<Page<CommentVo>, CommentPageParam, CommentAddParam, CommentUpdateParam> {
    List<CommentVo> listByArticleId(String articleId);
}
