package com.albo.cat.actions;

import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.albo.cat.util.ConstantHolder.EAT_PARAMETER;

@Component
public class CatEat implements CatAction {

    @Override
    public Map<String, String> doAction(Cat cat, String previousAction, PossibleActionsDataBase possibleActionsDataBase) {
        if (previousAction != null && previousAction.equals(EAT_PARAMETER)) {
            cat.setHappiness(cat.getHappiness() - 30);
        } else {
            cat.setHappiness(cat.getHappiness() + 5);
            cat.setSatiety(cat.getSatiety() + 15);
        }
        return possibleActionsDataBase.getActionsDataBase();
    }
}
