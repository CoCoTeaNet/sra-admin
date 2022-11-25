package net.cocotea.cms.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.cms.param.article.ArticleAddParam;
import net.cocotea.cms.param.article.ArticlePageParam;
import net.cocotea.cms.param.article.ArticleUpdateParam;
import net.cocotea.cms.service.IArticleService;
import net.cocotea.cms.vo.ArticleVo;
import net.cocotea.common.model.ApiResult;
import net.cocotea.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
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

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@RequestBody ArticleAddParam param) throws BusinessException {
        boolean add = articleService.add(param);
        return ApiResult.ok(add);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> delete(@RequestBody List<String> ids) throws BusinessException {
        boolean delete = articleService.deleteBatch(ids);
        return ApiResult.ok(delete);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody ArticleUpdateParam param) throws BusinessException {
        boolean update = articleService.update(param);
        return ApiResult.ok(update);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody ArticlePageParam param) throws BusinessException {
        Page<ArticleVo> list = articleService.listByPage(param);
        return ApiResult.ok(list);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("/detail/{articleId}")
    public ApiResult<?> detail(@PathVariable("articleId") String articleId) {
        ArticleVo article = articleService.detail(articleId);
        return ApiResult.ok(article);
    }
}
