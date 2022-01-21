package com.albo.cat.data.base;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.albo.cat.util.ConstantHolder.PLAY_PARAMETER;
import static com.albo.cat.util.ConstantHolder.EAT_PARAMETER;
import static com.albo.cat.util.ConstantHolder.SLEEP_PARAMETER;


@Component
@Getter
public class PossibleActionsDataBase {
    private final Map<String, String> actionsDataBase = new HashMap<>(){{
        put(PLAY_PARAMETER,"Поиграть с котом");
        put(EAT_PARAMETER,"Покормить кота");
        put(SLEEP_PARAMETER,"Уложить кота спать");
    }};
}
