package com.betbull.teamservice.util;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.entity.Team;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeCalculator {

    private static final BigDecimal STATIC_CHARGER = BigDecimal.valueOf(100000L);

    public static BigDecimal calculateTransferFeeWCommission(Team team, Player player) {
        BigDecimal transferFee = calculateTransferFee(player);
        BigDecimal commission = transferFee.multiply(team.getCommission());
        return transferFee.add(commission).setScale(2,RoundingMode.HALF_EVEN);
    }

    public static BigDecimal calculateTransferFee(Player player) {
        return STATIC_CHARGER
                .multiply(BigDecimal.valueOf(player.getExperience()))
                .divide(BigDecimal.valueOf(player.getAge()), RoundingMode.HALF_EVEN);
    }
}
