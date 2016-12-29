package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2016/11/10.
 */
@Controller
public class ErrorController {

    @RequestMapping("/error")
    public String error(String message, Model model) {
        model.addAttribute("message", message);
        return "error";
    }
}
