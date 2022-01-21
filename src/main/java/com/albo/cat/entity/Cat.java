package com.albo.cat.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component

@Getter
@Setter
@ToString
public class Cat {

    private String name;
    private final int age = 1;
    private int happiness;
    private int satiety;
    private String catAvatar = "/images/cat.jpg";
}
