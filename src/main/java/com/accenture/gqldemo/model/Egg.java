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

    @Enumerated(EnumType.STRING)
    private EggColorEnum eggColor;
}
