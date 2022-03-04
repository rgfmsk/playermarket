package com.betbull.teamservice.util;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.entity.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class FeeCalculatorTest {

    @Test
    void calculateTransferFeeWCommission() {
        BigDecimal withCommission = FeeCalculator.calculateTransferFeeWCommission(createTeam(), createPlayer());
        Assertions.assertEquals(withCommission.setScale(2, RoundingMode.HALF_EVEN),
                BigDecimal.valueOf(416667).add(BigDecimal.valueOf(41666.7)).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    void calculateTransferFee() {
        BigDecimal fee = FeeCalculator.calculateTransferFee(createPlayer());
        Assertions.assertEquals(fee.setScale(2, RoundingMode.HALF_EVEN),
                BigDecimal.valueOf(416667).setScale(2, RoundingMode.HALF_EVEN));
    }

    private Team createTeam() {
        Team team = new Team();
        team.setName("T1");
        team.setCommission(BigDecimal.valueOf(0.1d));
        return team;
    }

    private Player createPlayer() {
        Player player = new Player();
        player.setName("P1");
        player.setAge(24);
        player.setExperience(100);
        return player;
    }
}