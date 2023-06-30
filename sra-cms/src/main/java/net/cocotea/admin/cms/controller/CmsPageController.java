package net.cocotea.admin.cms.controller;

import net.cocotea.admin.cms.service.CmsArticleService;
import net.cocotea.admin.cms.service.CmsCommentService;
import net.cocotea.admin.cms.vo.CmsArchiveVO;
import net.cocotea.admin.cms.vo.CmsArticleVO;
import net.cocotea.admin.cms.vo.CmsTagVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CoCoTea
 */
@RequestMapping("/cmsPage")
@Controller
public class CmsPageController {
    @Resource
    private CmsArticleService cmsArticleService;
    @Resource
    private CmsCommentService cmsCommentService;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        // 获取文章列表（时间倒叙、评论数最多）
        List<CmsArticleVO> cmsArticleServiceByTimeDesc = cmsArticleService.findByTimeDesc();
        // 归档列表
        List<CmsArchiveVO> archiveVOList = cmsArticleService.findByArchiveList();
        // 获取标签列表
        List<CmsTagVO> tags = cmsArticleService.findTags(cmsArticleServiceByTimeDesc);
        modelMap.addAttribute("cmsArticleServiceByTimeDesc", cmsArticleServiceByTimeDesc);
        modelMap.addAttribute("archiveVoList", archiveVOList);
        modelMap.addAttribute("tags", tags);
        modelMap.addAttribute("title", "首页");
        return "index";
    }

    @GetMapping("/p/{articleId}")
    public String detail(@PathVariable("articleId") String articleId, ModelMap modelMap) {
        CmsArticleVO article = cmsArticleService.detail(articleId);
        modelMap.addAttribute("article", article);
        modelMap.addAttribute("archiveVoList", cmsArticleService.findByArchiveList());
        modelMap.addAttribute("tags", cmsArticleService.findTags(null));
        modelMap.addAttribute("articleCommentVoList", cmsCommentService.listByArticleId(articleId));
        modelMap.addAttribute("title", article.getTitle());
        return "detail";
    }
}
