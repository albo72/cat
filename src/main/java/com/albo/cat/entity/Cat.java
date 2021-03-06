package com.albo.cat.entity;

import com.albo.cat.actions.Action;
import lombok.*;
import org.springframework.stereotype.Component;


@Component

@Getter
@Setter
@ToString
public class Cat {

    private String name;
    private String age;
    private int happiness;
    private int satiety;
    private Action action;
    private boolean isCreated = false;
}
