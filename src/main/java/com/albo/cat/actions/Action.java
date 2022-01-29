package com.albo.cat.actions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    PLAY("Поиграть с котом", "Играаааю", "play.jpg"),
    SLEEP("Уложить кота спать", "Я сплю...", "sleep.jpg"),
    FEED("Покормить кота", "КушОю", "eat.jpg"),
    REST("Дать котику отдохнуть", "Чилю","cat.jpg");
    private final String title;
    private final String catSpeech;
    private String avatar;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
