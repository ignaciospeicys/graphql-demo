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

@Data
@Builder
@Entity
@Table(name = "CHICKEN")
public class Chicken {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    private int eggsLayed;

    @Convert(converter = BreedEnumConverter.class)
    private BreedEnum breed;
}
