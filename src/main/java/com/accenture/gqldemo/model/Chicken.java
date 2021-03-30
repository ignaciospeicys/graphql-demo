package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.enums.converter.BreedEnumConverter;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table
public class Chicken {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    @Convert(converter = BreedEnumConverter.class)
    private BreedEnum breed;

    @Builder.Default
    private int eggsLayed = 0;

    @Builder.Default
    private Set<Egg> eggs = new HashSet<>();
}
