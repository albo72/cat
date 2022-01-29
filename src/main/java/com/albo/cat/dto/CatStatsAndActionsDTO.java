package com.albo.cat.dto;

import com.albo.cat.actions.Action;
import com.albo.cat.entity.Cat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CatStatsAndActionsDTO {
    private String name;
    private String age;
    private int happiness;
    private int satiety;
    private Action currentAction;
    private List<Action> availableActionsWithCat;

    public static CatStatsAndActionsDTO getCatStatsAndActionsDTO(Cat cat, List<Action> actionsList){
        return CatStatsAndActionsDTO.builder().name(cat.getName()).age(cat.getAge()).
                happiness(cat.getHappiness()).satiety(cat.getSatiety()).currentAction(cat.getAction()).
                availableActionsWithCat(actionsList).build();
    }

}
