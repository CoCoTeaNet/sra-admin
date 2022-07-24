package com.sraapp.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CoCoTea
 */
@RequestMapping("/cmsPage")
@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        // 获取文章列表（时间倒叙、评论数最多）
        // 归档列表
        // 热门评论
        // 获取标签列表
        return "index";
    }

    @GetMapping("/detail/{articleId}")
    public String detail(@PathVariable("articleId") String articleId) {
        return "detail";
    }
}
