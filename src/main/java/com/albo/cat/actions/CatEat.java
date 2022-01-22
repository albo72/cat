package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.albo.cat.util.ConstantHolder.EAT_PARAMETER;

@Component("feed")
public class CatEat implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        if (cat.getAction() != null && cat.getAction().equals(EAT_PARAMETER)) {
            cat.setHappiness(cat.getHappiness() - 30);
        } else {
            cat.setHappiness(cat.getHappiness() + 5);
            cat.setSatiety(cat.getSatiety() + 15);
        }
        cat.setAction(EAT_PARAMETER);
        return new ArrayList<>(Arrays.asList(Action.values()));
    }
}
