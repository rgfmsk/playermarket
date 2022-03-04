package com.betbull.teamservice.init;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.entity.Team;
import com.betbull.teamservice.entity.Transfer;
import com.betbull.teamservice.service.PlayerService;
import com.betbull.teamservice.service.TeamService;
import com.betbull.teamservice.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


@Component
@RequiredArgsConstructor
public class DataInitializer {

    private static final List<Currency> currencyList = new ArrayList<>(Currency.getAvailableCurrencies());
    private static final int MIN_AGE = 12;
    private static final int MAX_AGE = 45;
    private static final double MIN_COMMISSION = 0d;
    private static final double MAX_COMMISSION = 0.1d;

    private final TeamService teamService;
    private final PlayerService playerService;
    private final TransferService transferService;

    @PostConstruct
    public void init() {
        generateTeams();
        generatePlayers();
        generateTransfers();
    }

    private void generateTeams() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Team t = new Team();
            t.setName(String.format("Team No:%s", i));
            t.setCurrency(currencyList.get(random(0, currencyList.size())));
            t.setCommission(BigDecimal.valueOf(random(MIN_COMMISSION, MAX_COMMISSION)));
            teamService.insert(t);
        });
    }

    private void generatePlayers() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Player p = new Player();
            p.setName(String.format("Player No:%s", i));
            p.setAge(random(MIN_AGE, MAX_AGE));
            p.setExperience((random(0, p.getAge() - MIN_AGE + 1) * 12));
            playerService.insert(p);
        });
    }

    private void generateTransfers() {
        List<Player> players = playerService.findAll();
        List<Team> teams = teamService.findAll();
        players.forEach(player -> {
            Team team = teams.get(random(0, teams.size() - 1));
            Transfer transfer = new Transfer();
            transfer.setPlayer(player);
            transfer.setTeam(team);
            transfer.setTransferDate(LocalDate.now().minusYears(random(0, player.getAge()-MIN_AGE+1)));
            transferService.save(transfer);
        });
    }

    public static double random(double min, double max) {
        return new Random().doubles(min, max).limit(1).findFirst().getAsDouble();
    }

    public static int random(int min, int max) {
        return new Random().ints(min, max).limit(1).findFirst().getAsInt();
    }
}
