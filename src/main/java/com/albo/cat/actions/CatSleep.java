package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.albo.cat.util.ConstantHolder.SLEEP_PARAMETER;

@Component("sleep")
public class CatSleep implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        cat.setHappiness(cat.getHappiness() + 10);
        cat.setAction(SLEEP_PARAMETER);
        return new ArrayList<>(Collections.singleton(Action.PLAY));
    }
}
