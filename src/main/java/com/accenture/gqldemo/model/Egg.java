package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.EggColorEnum;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table
public class Egg {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Chicken chicken;

    @Column(name = "chicken", insertable = false, updatable = false)
    private Integer chickenId;

    @Enumerated(EnumType.STRING)
    private EggColorEnum eggColor;
}
