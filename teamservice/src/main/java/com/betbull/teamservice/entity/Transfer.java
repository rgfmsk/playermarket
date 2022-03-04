package com.betbull.teamservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Transfer extends BaseEntity {

    private LocalDate transferDate;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Team team;
}
