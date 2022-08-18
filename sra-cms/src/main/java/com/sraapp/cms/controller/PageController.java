package com.sraapp.cms.controller;

import com.sraapp.cms.service.IArticleService;
import com.sraapp.cms.service.ICommentService;
import com.sraapp.cms.vo.ArchiveVo;
import com.sraapp.cms.vo.ArticleVo;
import com.sraapp.cms.vo.CommentVo;
import com.sraapp.cms.vo.TagVo;
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
        // 热门评论
        List<CommentVo> commentVoList = commentService.findHotComment();
        // 获取标签列表
        List<TagVo> tags = articleService.findTags(articleServiceByTimeDesc);
        modelMap.addAttribute("articleServiceByTimeDesc", articleServiceByTimeDesc);
        modelMap.addAttribute("archiveVoList", archiveVoList);
        modelMap.addAttribute("commentVoList", commentVoList);
        modelMap.addAttribute("tags", tags);
        modelMap.addAttribute("title", "首页");
        return "index";
    }

    @GetMapping("/p/{articleId}")
    public String detail(@PathVariable("articleId") String articleId, ModelMap modelMap) {
        ArticleVo article = articleService.detail(articleId);
        modelMap.addAttribute("article", article);
        modelMap.addAttribute("archiveVoList", articleService.findByArchiveList());
        modelMap.addAttribute("commentVoList", commentService.findHotComment());
        modelMap.addAttribute("tags", articleService.findTags(null));
        modelMap.addAttribute("title", article.getTitle());
        return "detail";
    }
}
