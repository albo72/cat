package com.albo.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WelcomePageController {

    private static final String WELCOME_PAGE_NAME = "welcome";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap modelMap){
        return WELCOME_PAGE_NAME;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getCatName(@RequestParam String name){

        return "welcome";
    }

}
