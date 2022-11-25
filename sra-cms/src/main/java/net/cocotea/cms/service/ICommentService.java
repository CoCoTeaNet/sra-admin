package net.cocotea.cms.service;

import net.cocotea.cms.param.comment.CommentAddParam;
import net.cocotea.cms.param.comment.CommentPageParam;
import net.cocotea.cms.param.comment.CommentUpdateParam;
import net.cocotea.cms.vo.CommentVo;
import net.cocotea.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public interface ICommentService extends IBaseService<Page<CommentVo>, CommentPageParam, CommentAddParam, CommentUpdateParam> {
    List<CommentVo> listByArticleId(String articleId);
}
