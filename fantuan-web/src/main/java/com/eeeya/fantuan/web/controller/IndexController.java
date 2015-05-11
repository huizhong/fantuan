package com.eeeya.fantuan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhonghui
 * @since 5/12/15.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String getAppInfo(Model model) {
        return "index";
    }
}
