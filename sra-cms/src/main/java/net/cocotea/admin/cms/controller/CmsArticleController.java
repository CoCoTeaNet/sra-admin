package net.cocotea.admin.cms.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.cms.service.CmsArticleService;
import net.cocotea.admin.cms.vo.CmsArticleVO;
import net.cocotea.admin.cms.param.article.CmsArticleAddParam;
import net.cocotea.admin.cms.param.article.CmsArticlePageParam;
import net.cocotea.admin.cms.param.article.CmsArticleUpdateParam;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
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
public class CmsArticleController {
    @Resource
    private CmsArticleService cmsArticleService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@RequestBody CmsArticleAddParam param) throws BusinessException {
        boolean add = cmsArticleService.add(param);
        return ApiResult.ok(add);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> delete(@RequestBody List<String> ids) throws BusinessException {
        boolean delete = cmsArticleService.deleteBatch(ids);
        return ApiResult.ok(delete);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody CmsArticleUpdateParam param) throws BusinessException {
        boolean update = cmsArticleService.update(param);
        return ApiResult.ok(update);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody CmsArticlePageParam param) throws BusinessException {
        Page<CmsArticleVO> list = cmsArticleService.listByPage(param);
        return ApiResult.ok(list);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("/detail/{articleId}")
    public ApiResult<?> detail(@PathVariable("articleId") String articleId) {
        CmsArticleVO article = cmsArticleService.detail(articleId);
        return ApiResult.ok(article);
    }
}
