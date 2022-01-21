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
public class CatAvatarsDataBase {
    private final Map<String, String> avatars = new HashMap<>(){{
        put(PLAY_PARAMETER,"/images/play.jpg");
        put(EAT_PARAMETER,"/images/eat.jpg");
        put(SLEEP_PARAMETER,"/images/sleep.jpg");
    }};
}
