package net.cocotea.admin.cms.service;

import net.cocotea.admin.cms.vo.CmsCommentVO;
import net.cocotea.admin.cms.param.comment.CmsCommentAddParam;
import net.cocotea.admin.cms.param.comment.CmsCommentPageParam;
import net.cocotea.admin.cms.param.comment.CmsCommentUpdateParam;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public interface CmsCommentService extends IBaseService<Page<CmsCommentVO>, CmsCommentPageParam, CmsCommentAddParam, CmsCommentUpdateParam> {
    List<CmsCommentVO> listByArticleId(String articleId);
}
