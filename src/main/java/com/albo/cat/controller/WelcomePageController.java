package com.albo.cat.controller;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.albo.cat.util.ConstantHolder.*;

@Controller
public class WelcomePageController {
    private final Cat cat;

    private static final String WELCOME_PAGE_NAME = "welcome";
    private static final String CAT_STATS_CONTROLLER_NAME = "cat_stats";

    public WelcomePageController(Cat cat) {
        this.cat = cat;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        if (cat.getName() == null) {
            return WELCOME_PAGE_NAME;
        } else {
            return REDIRECT + CAT_STATS_CONTROLLER_NAME;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getCatName(@ModelAttribute("name") String name) {
        cat.setName(name);
        cat.setHappiness(START_VALUE_OF_CAT_HAPPINESS);
        cat.setSatiety(START_VALUE_OF_CAT_SATIETY);
        return REDIRECT + CAT_STATS_CONTROLLER_NAME;
    }
}
