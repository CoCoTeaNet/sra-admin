package net.cocotea.cms.controller;

import net.cocotea.cms.service.IArticleService;
import net.cocotea.cms.service.ICommentService;
import net.cocotea.cms.vo.ArchiveVo;
import net.cocotea.cms.vo.ArticleVo;
import net.cocotea.cms.vo.TagVo;
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
public class PageController {
    @Resource
    private IArticleService articleService;
    @Resource
    private ICommentService commentService;

    @GetMapping("/index")
    public String index(ModelMap modelMap) {
        // 获取文章列表（时间倒叙、评论数最多）
        List<ArticleVo> articleServiceByTimeDesc = articleService.findByTimeDesc();
        // 归档列表
        List<ArchiveVo> archiveVoList = articleService.findByArchiveList();
        // 获取标签列表
        List<TagVo> tags = articleService.findTags(articleServiceByTimeDesc);
        modelMap.addAttribute("articleServiceByTimeDesc", articleServiceByTimeDesc);
        modelMap.addAttribute("archiveVoList", archiveVoList);
        modelMap.addAttribute("tags", tags);
        modelMap.addAttribute("title", "首页");
        return "index";
    }

    @GetMapping("/p/{articleId}")
    public String detail(@PathVariable("articleId") String articleId, ModelMap modelMap) {
        ArticleVo article = articleService.detail(articleId);
        modelMap.addAttribute("article", article);
        modelMap.addAttribute("archiveVoList", articleService.findByArchiveList());
        modelMap.addAttribute("tags", articleService.findTags(null));
        modelMap.addAttribute("articleCommentVoList", commentService.listByArticleId(articleId));
        modelMap.addAttribute("title", article.getTitle());
        return "detail";
    }
}
