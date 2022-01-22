package com.albo.cat.controller;

import com.albo.cat.actions.Action;
import com.albo.cat.actions.ActionProcessor;
import com.albo.cat.entity.Cat;
import com.albo.cat.exception.ActionNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.albo.cat.util.ConstantHolder.REDIRECT;

@Controller
public class CatStatsController {
    private final ActionProcessor actionProcessor;
    private final Cat cat;

    private static final String CAT_STATS_PAGE_NAME = "cat_stats";
    private static final String ERROR_PAGE_NAME = "error";
    private static final String ACTIONS_ATTRIBUTE = "actions";
    private static final String CAT_ATTRIBUTE = "cat";

    public CatStatsController(ActionProcessor actionProcessor, Cat cat) {
        this.actionProcessor = actionProcessor;
        this.cat = cat;
    }

    @RequestMapping(value = "/cat_stats", method = RequestMethod.GET)
    public String changeStats(@RequestParam(value = "catAction", required = false) String action, ModelMap modelMap) {
        if(!cat.isCreated()){
            return REDIRECT;
        }
        try {
            List<Action> actionsList = actionProcessor.doProcess(cat, action);
            modelMap.addAttribute(ACTIONS_ATTRIBUTE, actionsList);
            modelMap.addAttribute(CAT_ATTRIBUTE, cat);
        } catch (ActionNotFoundException e) {
            return ERROR_PAGE_NAME;
        }
        return CAT_STATS_PAGE_NAME;
    }
}
