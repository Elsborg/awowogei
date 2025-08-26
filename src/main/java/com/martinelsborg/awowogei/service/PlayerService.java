package com.martinelsborg.awowogei.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.martinelsborg.awowogei.model.Player;
import com.martinelsborg.awowogei.repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(String username) {
        return repo.findByUsername(username);
    }

    public Player savePlayer(Player player) {
        return repo.save(player);
    }
}
