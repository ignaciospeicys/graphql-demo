package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.BreedEnum;
import com.accenture.gqldemo.enums.converter.BreedEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm", insertable = false, updatable = false)
    private Farm farm;

    /**
     * We use this field for inserts to improve performance while relying on the db's integrity via Foreign Keys
     */
    @Column(name = "farm")
    private int farmId;

    @Builder.Default
    private int eggsLayed = 0;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Egg> eggs = new HashSet<>();
}
