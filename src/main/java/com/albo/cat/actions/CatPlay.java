package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("PLAY")
public class CatPlay implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        if (cat.getAction().equals(Action.SLEEP)) {
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
        cat.setAction(Action.PLAY);
        return new ArrayList<>(Arrays.asList(Action.values()));
    }
}
