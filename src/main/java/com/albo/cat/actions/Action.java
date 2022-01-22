package com.albo.cat.actions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    PLAY("Поиграть с котом","/images/play.jpg"),
    SLEEP("Уложить кота спать","/images/sleep.jpg"),
    FEED("Покормить кота","/images/eat.jpg");
    private final String title;
    private final String avatar;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
