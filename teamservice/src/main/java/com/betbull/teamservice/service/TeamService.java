package com.betbull.teamservice.service;

import com.betbull.teamservice.entity.Team;
import com.betbull.teamservice.exception.TeamNotFoundException;
import com.betbull.teamservice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team insert(Team model) {
        Team team = new Team();
        team.setCurrency(model.getCurrency());
        team.setName(model.getName());
        team.setCommission(model.getCommission());
        return teamRepository.save(team);
    }

    public Team update(Long id, Team model) {
        Optional<Team> byId = teamRepository.findById(id);
        if (byId.isPresent()) {
            Team team = byId.get();
            team.setCurrency(model.getCurrency());
            team.setName(model.getName());
            team.setCommission(model.getCommission());
            return teamRepository.save(team);
        } else {
            throw new TeamNotFoundException(id);
        }
    }

    public void delete(Long id) {
        Optional<Team> byId = teamRepository.findById(id);
        if (!byId.isPresent()) {
            throw new TeamNotFoundException(id);
        } else {
            teamRepository.deleteById(id);
        }
    }

    public Team find(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

}
