package com.betbull.teamservice.controller;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.service.PlayerService;
import com.betbull.teamservice.service.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Players API")
@RequestMapping("api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final TransferService transferService;

    @GetMapping
    @ApiOperation(value = "Get All Players")
    public List<Player> getPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Player")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.find(id);
    }

    @PutMapping
    @ApiOperation(value = "Insert Players")
    public Player create(@RequestBody Player player) {
        return playerService.insert(player);
    }

    @PostMapping("{id}")
    @ApiOperation(value = "Edit Players")
    public Player create(@PathVariable Long id, @RequestBody Player player) {
        return playerService.update(id, player);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Players")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
