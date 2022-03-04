package com.betbull.teamservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Player extends BaseEntity {
    private String name;
    private Integer experience;
    private Integer age;

}
