package com.albo.cat.entity;

import com.albo.cat.actions.Action;
import com.albo.cat.actions.CatAction;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@Getter
@Setter
@ToString
public class Cat {

    private String name;
    private final int age = 1;
    private int happiness;
    private int satiety;
    private CatAction catAction;
    private String action;
    private boolean isCreated = false;
    private String catAvatar = "/images/cat.jpg";

    public List<Action> doAction(){
        return catAction.doAction(this);
    }
}
