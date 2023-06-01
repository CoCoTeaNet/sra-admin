package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.CommentVO;
import net.cocotea.admin.cms.param.comment.CommentAddParam;
import net.cocotea.admin.cms.param.comment.CommentPageParam;
import net.cocotea.admin.cms.param.comment.CommentUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public interface ICommentService extends IBaseService<Page<CommentVO>, CommentPageParam, CommentAddParam, CommentUpdateParam> {
    List<CommentVO> listByArticleId(String articleId);
}
