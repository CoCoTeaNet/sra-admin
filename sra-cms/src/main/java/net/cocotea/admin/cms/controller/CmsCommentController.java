package net.cocotea.admin.cms.controller;

import net.cocotea.admin.cms.param.comment.CmsCommentAddParam;
import net.cocotea.admin.cms.param.comment.CmsCommentPageParam;
import net.cocotea.admin.cms.service.CmsCommentService;
import net.cocotea.admin.cms.vo.CmsCommentVO;
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
public class CmsCommentController {
    @Resource
    private CmsCommentService cmsCommentService;

    @PostMapping("/add")
    ApiResult<?> add(@Valid @RequestBody CmsCommentAddParam param) throws BusinessException {
        boolean add = cmsCommentService.add(param);
        return ApiResult.flag(add);
    }

    @PostMapping("listByPage")
    ApiResult<?> listByPage(@Valid @RequestBody CmsCommentPageParam param) throws BusinessException {
        Page<CmsCommentVO> list = cmsCommentService.listByPage(param);
        return ApiResult.ok(list);
    }

    @PostMapping("deleteBatch")
    ApiResult<?> listByPage(@Valid @RequestBody List<String> idList) throws BusinessException {
        boolean b = cmsCommentService.deleteBatch(idList);
        return ApiResult.flag(b);
    }
}
