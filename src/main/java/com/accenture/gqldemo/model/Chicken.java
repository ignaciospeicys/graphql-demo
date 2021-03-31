package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.enums.converter.BreedEnumConverter;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Farm farm;

    /**
     * We use this field for inserts to improve performance while relying on the db's integrity via Foreign Keys
     */
    @Column(name = "farm")
    private int farmId;

    @Builder.Default
    private int eggsLayed = 0;

    @Builder.Default
    @OneToMany
    private Set<Egg> eggs = new HashSet<>();
}
