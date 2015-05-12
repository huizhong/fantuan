package com.eeeya.fantuan.controller.view;

import com.eeeya.fantuan.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ben@eeeya.com
 * @since 4/17/15
 */
@Controller
public class ViewController {
    @Autowired
    AppConfig appConfig;

    @RequestMapping("/app/info")
    String getAppInfo(Model model) {
        model.addAttribute("data", appConfig);
        return "appInfo";
    }

}
