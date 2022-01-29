package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component("REST")
public class CatRest implements CatAction {
    @Override
    public List<Action> doAction(Cat cat) {
        cat.setAction(Action.REST);
        List<Action> actionsList = new ArrayList<>(Arrays.asList(Action.values()));
        actionsList.remove(Action.REST);
        return actionsList;
    }
}
