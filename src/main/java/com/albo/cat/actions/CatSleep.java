package com.albo.cat.actions;

import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.albo.cat.util.ConstantHolder.PLAY_PARAMETER;

@Component
public class CatSleep implements CatAction {

    @Override
    public Map<String, String> doAction(Cat cat, String previousAction, PossibleActionsDataBase possibleActionsDataBase) {
        Map<String, String> mapOfAvailableActions = new HashMap<>();
        mapOfAvailableActions.put(PLAY_PARAMETER, possibleActionsDataBase.getActionsDataBase().get(PLAY_PARAMETER));
        cat.setHappiness(cat.getHappiness() + 10);
        return mapOfAvailableActions;
    }
}
