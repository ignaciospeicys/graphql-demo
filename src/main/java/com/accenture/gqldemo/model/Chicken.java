package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.BreedEnum;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private int eggsLayed;

    //TODO: enum converter
    private BreedEnum breed;
}
