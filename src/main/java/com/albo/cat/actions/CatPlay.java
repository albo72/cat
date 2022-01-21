package com.albo.cat.actions;

import com.albo.cat.data.base.PossibleActionsDataBase;
import com.albo.cat.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

import static com.albo.cat.util.ConstantHolder.SLEEP_PARAMETER;

@Component
public class CatPlay implements CatAction {

    @Override
    public Map<String, String> doAction(Cat cat, String previousAction, PossibleActionsDataBase possibleActionsDataBase) {
        if (previousAction != null && previousAction.equals(SLEEP_PARAMETER)) {
            cat.setHappiness(cat.getHappiness() - 5);
        } else {
            Random random = new Random();
            int newRandom = random.nextInt(3);
            if (newRandom == 0) {
                cat.setHappiness(0);
            } else {
                cat.setHappiness(cat.getHappiness() + 15);
            }
            cat.setSatiety(cat.getSatiety() - 10);
        }
        return possibleActionsDataBase.getActionsDataBase();
    }
}
