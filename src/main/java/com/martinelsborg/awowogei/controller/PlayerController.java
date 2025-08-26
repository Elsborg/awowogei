package com.martinelsborg.awowogei.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinelsborg.awowogei.model.Player;
import com.martinelsborg.awowogei.service.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> getAll() {
        return service.getAllPlayers();
    }

    @GetMapping("/{username}")
    public Player getOne(@PathVariable String username) {
        return service.getPlayer(username);
    }

    @PostMapping
    public Player add(@RequestBody Player player) {
        return service.savePlayer(player);
    }
}