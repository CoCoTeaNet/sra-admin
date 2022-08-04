package com.sraapp.cms.service;

import com.sraapp.cms.param.comment.CommentAddParam;
import com.sraapp.cms.param.comment.CommentPageParam;
import com.sraapp.cms.param.comment.CommentUpdateParam;
import com.sraapp.cms.vo.CommentVo;
import com.sraapp.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public interface ICommentService extends IBaseService<Page<CommentVo>, CommentPageParam, CommentAddParam, CommentUpdateParam> {
    List<CommentVo> findHotComment();
}
