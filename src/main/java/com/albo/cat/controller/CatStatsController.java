package com.albo.cat.controller;

import com.albo.cat.actions.ActionProcessor;
import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import static com.albo.cat.util.ConstantHolder.REDIRECT;

@Controller
public class CatStatsController {
    private final ActionProcessor actionProcessor;
    private final Cat cat;

    private static final String CAT_STATS_PAGE_NAME = "cat_stats";
    private static final String ACTIONS_ATTRIBUTE = "actions";
    private static final String CAT_ATTRIBUTE = "cat";

    public CatStatsController(ActionProcessor actionProcessor, Cat cat) {
        this.actionProcessor = actionProcessor;
        this.cat = cat;
    }

    @RequestMapping(value = "/cat_stats", method = RequestMethod.GET)
    public String changeStats(@RequestParam(value = "catAction", required = false) String action, ModelMap modelMap) {
        if(cat.getName() == null){
            return REDIRECT;
        }
        modelMap.addAttribute(ACTIONS_ATTRIBUTE, actionProcessor.doProcess(cat, action));
        modelMap.addAttribute(CAT_ATTRIBUTE, cat);
        return CAT_STATS_PAGE_NAME;
    }
}
