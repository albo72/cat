package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component("FEED")
public class CatEat implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        if (cat.getAction().equals(Action.FEED)) {
            cat.setHappiness(cat.getHappiness() - 30);
        } else {
            cat.setHappiness(cat.getHappiness() + 5);
            cat.setSatiety(cat.getSatiety() + 15);
        }
        cat.setAction(Action.FEED);
        return new ArrayList<>(Arrays.asList(Action.values()));
    }
}
