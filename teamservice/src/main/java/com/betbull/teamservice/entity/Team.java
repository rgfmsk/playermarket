package com.betbull.teamservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
@Getter
@Setter
public class Team extends BaseEntity {
    private String name;
    private Currency currency;
    private BigDecimal commission;
}
