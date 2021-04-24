package com.accenture.gqldemo.model;

import com.accenture.gqldemo.enums.EggColorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Egg {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chicken", insertable = false, updatable = false)
    private Chicken chicken;

    @Column(name = "chicken")
    private Integer chickenId;

    @Enumerated(EnumType.STRING)
    private EggColorEnum color;
}
