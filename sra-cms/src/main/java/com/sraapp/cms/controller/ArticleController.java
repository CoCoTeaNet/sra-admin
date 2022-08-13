package com.sraapp.cms.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.sraapp.cms.param.article.ArticleAddParam;
import com.sraapp.cms.param.article.ArticlePageParam;
import com.sraapp.cms.param.article.ArticleUpdateParam;
import com.sraapp.cms.service.IArticleService;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章接口
 *
 * @date 2022-7-24 16:02:26
 * @author CoCoTea
 */
@RestController
@RequestMapping("/cms/article")
public class ArticleController {
    @Resource
    private IArticleService articleService;

    @ApiOperation("新增文章")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@RequestBody ArticleAddParam param) throws BusinessException {
        boolean add = articleService.add(param);
        return ApiResult.ok(add);
    }

    @ApiOperation("批量删除文章")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> delete(@RequestBody List<String> ids) throws BusinessException {
        boolean delete = articleService.deleteBatch(ids);
        return ApiResult.ok(delete);
    }

    @ApiOperation("更新文章")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody ArticleUpdateParam param) throws BusinessException {
        boolean update = articleService.update(param);
        return ApiResult.ok(update);
    }

    @ApiOperation("文章列表")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody ArticlePageParam param) throws BusinessException {
        Page<ArticleVo> list = articleService.listByPage(param);
        return ApiResult.ok(list);
    }

    @ApiOperation("文章详细")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("/detail/{articleId}")
    public ApiResult<?> detail(@PathVariable("articleId") String articleId) {
        ArticleVo article = articleService.detail(articleId);
        return ApiResult.ok(article);
    }
}
