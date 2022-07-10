package com.jwss.sra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jwss
 */
@RequestMapping("/cmsPage")
@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
