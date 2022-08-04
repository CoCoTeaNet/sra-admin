package com.sraapp.cms.service.impl;

import com.sraapp.cms.param.comment.CommentAddParam;
import com.sraapp.cms.param.comment.CommentPageParam;
import com.sraapp.cms.param.comment.CommentUpdateParam;
import com.sraapp.cms.service.ICommentService;
import com.sraapp.cms.vo.CommentVo;
import com.sraapp.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

public class CommentServiceImpl implements ICommentService {
    @Override
    public boolean add(CommentAddParam param) throws BusinessException {
        return false;
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
    public List<CommentVo> findHotComment() {
        return null;
    }
}
