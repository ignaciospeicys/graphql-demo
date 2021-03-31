package com.accenture.gqldemo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table
public class Farm {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Builder.Default
    private int chickenCount = 0;

    @OneToMany
    @Builder.Default
    private Set<Chicken> chickens = new HashSet<>();
}
