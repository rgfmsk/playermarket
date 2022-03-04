package com.betbull.teamservice.service;

import com.betbull.teamservice.entity.Player;
import com.betbull.teamservice.exception.PlayerNotFoundException;
import com.betbull.teamservice.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player insert(Player model) {
        Player player = new Player();
        player.setAge(model.getAge());
        player.setName(model.getName());
        player.setExperience(model.getExperience());
        return playerRepository.save(player);
    }

    public Player update(Long id, Player model) {
        Optional<Player> byId = playerRepository.findById(id);
        if (byId.isPresent()) {
            Player player = byId.get();
            player.setAge(model.getAge());
            player.setName(model.getName());
            player.setExperience(model.getExperience());
            return playerRepository.save(player);
        } else {
            throw new PlayerNotFoundException(id);
        }
    }

    public void delete(Long id) {
        Optional<Player> byId = playerRepository.findById(id);
        if (!byId.isPresent()) {
            throw new PlayerNotFoundException(id);
        } else {
            playerRepository.deleteById(id);
        }
    }

    public Player find(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

}
