package com.albo.cat.actions;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.albo.cat.util.ConstantHolder.PLAY_PARAMETER;
import static com.albo.cat.util.ConstantHolder.SLEEP_PARAMETER;

@Component("play")
public class CatPlay implements CatAction {

    @Override
    public List<Action> doAction(Cat cat) {
        if (cat.getAction() != null && cat.getAction().equals(SLEEP_PARAMETER)) {
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
        cat.setAction(PLAY_PARAMETER);
        return new ArrayList<>(Arrays.asList(Action.values()));
    }
}
