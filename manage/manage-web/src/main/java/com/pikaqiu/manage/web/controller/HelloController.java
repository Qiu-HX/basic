package com.pikaqiu.manage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 2017/7/20.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/login")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}
