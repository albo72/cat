package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.*;


@Component("SLEEP")
public class CatSleep implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        cat.setHappiness(cat.getHappiness() + 10);
        cat.setAction(Action.SLEEP);
        return new ArrayList<>(Collections.singleton(Action.PLAY));
    }
}
