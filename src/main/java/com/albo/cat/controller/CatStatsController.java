package com.albo.cat.controller;

import com.albo.cat.actions.Action;
import com.albo.cat.actions.ActionProcessor;
import com.albo.cat.dto.CatStatsAndActionsDTO;
import com.albo.cat.entity.Cat;
import com.albo.cat.exception.ActionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.albo.cat.util.ConstantHolder.REDIRECT;

@Controller
@RequestMapping("/cat_stats")
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

    @GetMapping
    public String changeStats(
            @RequestParam(value = "catAction", required = false, defaultValue = "REST") String actionStr,
            ModelMap modelMap) {
        if (!cat.isCreated()) {
            return REDIRECT;
        }
        try {
            Action action = getExistingAction(actionStr);
            List<Action> actionsList = actionProcessor.doProcess(cat, action);
            modelMap.addAttribute(ACTIONS_ATTRIBUTE, actionsList);
            modelMap.addAttribute(CAT_ATTRIBUTE, cat);
            return CAT_STATS_PAGE_NAME;
        } catch (ActionNotFoundException e) {
            return ERROR_PAGE_NAME;
        }

    }

    @GetMapping("/api")
    public ResponseEntity<?> changeStatsApi(
            @RequestParam(value = "catAction", required = false, defaultValue = "REST") String actionStr) {
        if (!cat.isCreated()) {
            return ResponseEntity.badRequest().body("Кот не создан!");
        }
        actionStr = actionStr.toUpperCase();
        try {
            Action action = getExistingAction(actionStr);
            List<Action> actionList = actionProcessor.doProcess(cat, action);
            return ResponseEntity.ok().body(CatStatsAndActionsDTO.getCatStatsAndActionsDTO(cat, actionList));
        } catch (ActionNotFoundException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    private Action getExistingAction(String actionStr) throws ActionNotFoundException {
        Action action = null;
        boolean exists = false;
        for (Action value : Action.values()) {
            if(actionStr.equals(value.toString())){
                exists = true;
                action = Action.valueOf(actionStr);
            }
        }
        if(!exists){
            throw new ActionNotFoundException("Неверный запрос! Такого действия не существует.");
        }
        return action;
    }

}