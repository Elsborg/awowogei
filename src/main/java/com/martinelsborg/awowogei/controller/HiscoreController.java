package com.martinelsborg.awowogei.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinelsborg.awowogei.model.Skill;
import com.martinelsborg.awowogei.service.HiscoreService;


@RestController
 @RequestMapping("/api/hiscores")
public class HiscoreController {
    private final HiscoreService service;

    public HiscoreController(HiscoreService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public List<Skill> getPlayerStats(@PathVariable String username) {
        return service.getPlayerStats(username);
    }
}
