package com.sraapp.cms.controller;

import com.sraapp.cms.param.comment.CommentAddParam;
import com.sraapp.cms.param.comment.CommentPageParam;
import com.sraapp.cms.service.ICommentService;
import com.sraapp.cms.vo.CommentVo;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 评论接口
 *
 * @date 2022-8-21 03:34:25
 * @author CoCoTea
 */
@RestController
@RequestMapping("/cms/comment")
public class CommentController {
    @Resource
    private ICommentService commentService;

    @PostMapping("/add")
    ApiResult<?> add(@Valid @RequestBody CommentAddParam param) throws BusinessException {
        boolean add = commentService.add(param);
        return ApiResult.flag(add);
    }

    @PostMapping("listByPage")
    ApiResult<?> listByPage(@Valid @RequestBody CommentPageParam param) throws BusinessException {
        Page<CommentVo> list = commentService.listByPage(param);
        return ApiResult.ok(list);
    }

    @PostMapping("deleteBatch")
    ApiResult<?> listByPage(@Valid @RequestBody List<String> idList) throws BusinessException {
        boolean b = commentService.deleteBatch(idList);
        return ApiResult.flag(b);
    }
}
