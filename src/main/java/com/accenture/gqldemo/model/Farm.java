package com.accenture.gqldemo.model;

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
public class Farm {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Builder.Default
    private int chickenCount = 0;

    @OneToMany(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Chicken> chickens = new HashSet<>();
}
