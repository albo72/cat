package com.albo.cat.actions;

import com.albo.cat.data.base.CatAvatarsDataBase;
import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;
import com.albo.cat.util.CheckerCatParameters;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ActionProcessor {

    private final PossibleActionsDataBase possibleActionsDataBase;
    private final CatAvatarsDataBase catAvatarsDataBase;
    private final CatAction actionPlay;
    private final CatAction actionSleep;
    private final CatAction actionEat;
    private final CheckerCatParameters checkerCatParameters;

    private String action;


    public ActionProcessor(PossibleActionsDataBase possibleActionsDataBase, CatAvatarsDataBase catAvatarsDataBase,
                           @Qualifier("catPlay") CatAction actionPlay, @Qualifier("catSleep") CatAction actionSleep,
                           @Qualifier("catEat") CatAction actionEat, CheckerCatParameters checkerCatParameters) {
        this.possibleActionsDataBase = possibleActionsDataBase;
        this.catAvatarsDataBase = catAvatarsDataBase;
        this.actionPlay = actionPlay;
        this.actionSleep = actionSleep;
        this.actionEat = actionEat;
        this.checkerCatParameters = checkerCatParameters;
    }

    public Map<String, String> doProcess(Cat cat, String newAction) {
        Map<String, String> mapOfAvailableActions = null;
        if (newAction == null) {
            mapOfAvailableActions = possibleActionsDataBase.getActionsDataBase();
        } else {
            switch (newAction) {
                case "sleep":
                    mapOfAvailableActions = actionSleep.doAction(cat, action, possibleActionsDataBase);
                    break;
                case "play":
                    mapOfAvailableActions = actionPlay.doAction(cat, action, possibleActionsDataBase);
                    break;
                case "feed":
                    mapOfAvailableActions = actionEat.doAction(cat, action, possibleActionsDataBase);
                    break;
            }
            checkerCatParameters.checkAndEdit(cat);
            cat.setCatAvatar(catAvatarsDataBase.getAvatars().get(newAction));
        }
        action = newAction;
        return mapOfAvailableActions;
    }

}

