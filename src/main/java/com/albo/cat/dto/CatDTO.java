package com.albo.cat.dto;

import com.albo.cat.entity.Cat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CatDTO {
    private String name;
    private String age;
    private int happiness;
    private int satiety;

    public static CatDTO getCatDTO(Cat cat){
        return CatDTO.builder().name(cat.getName()).age(cat.getAge()).
                happiness(cat.getHappiness()).satiety(cat.getSatiety()).build();
    }

}
