package com.betbull.teamservice.controller;

import com.betbull.teamservice.entity.Team;
import com.betbull.teamservice.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Teams API")
@RequestMapping("api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    @ApiOperation(value = "Get All Teams")
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get Team")
    public Team getTeams(@PathVariable Long id) {
        return teamService.find(id);
    }

    @PutMapping
    @ApiOperation(value = "Insert Teams")
    public Team create(@RequestBody Team team) {
        return teamService.insert(team);
    }

    @PostMapping("{id}")
    @ApiOperation(value = "Edit Teams")
    public Team create(@PathVariable Long id, @RequestBody Team team) {
        return teamService.update(id, team);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Teams")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}
