package net.cocotea.admin.cms.controller;

import net.cocotea.admin.cms.param.comment.CommentAddParam;
import net.cocotea.admin.cms.param.comment.CommentPageParam;
import net.cocotea.admin.cms.service.ICommentService;
import net.cocotea.admin.cms.vo.CommentVO;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
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
        Page<CommentVO> list = commentService.listByPage(param);
        return ApiResult.ok(list);
    }

    @PostMapping("deleteBatch")
    ApiResult<?> listByPage(@Valid @RequestBody List<String> idList) throws BusinessException {
        boolean b = commentService.deleteBatch(idList);
        return ApiResult.flag(b);
    }
}
