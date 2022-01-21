package com.albo.cat.actions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    SLEEP("Уложить кота спать"),
    PLAY("Поиграть с котом"),
    FEED("Покормить кота");
    private String title;
}
