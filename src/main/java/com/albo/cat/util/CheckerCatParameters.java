package com.albo.cat.util;

import com.albo.cat.entity.Cat;
import org.springframework.stereotype.Component;

@Component
public class CheckerCatParameters {

    public void checkAndEdit(Cat cat){
        if(cat.getHappiness() < 0){
            cat.setHappiness(0);
        }
        if (cat.getSatiety() < 0){
            cat.setSatiety(0);
        }
    }
}
