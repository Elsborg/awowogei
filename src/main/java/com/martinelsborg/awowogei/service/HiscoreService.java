package com.martinelsborg.awowogei.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.martinelsborg.awowogei.exception.PlayerNotFoundException;
import com.martinelsborg.awowogei.model.Skill;

@Service
public class HiscoreService {
    private final String API_URL = 
        "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";

    private final List<String> skillNames = Arrays.asList(
        "Overall", "Attack", "Defence", "Strength", "Hitpoints",
        "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting",
        "Fletching", "Fishing", "Firemaking", "Crafting",
        "Smithing", "Mining", "Herblore", "Agility", "Thieving",
        "Slayer", "Farming", "Runecraft", "Hunter", "Construction"
    );

    @Cacheable("hiscores")
    public List<Skill> getPlayerStats(String username) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject(API_URL + username, String.class);
    
            if (response == null || response.isEmpty()) {
                throw new PlayerNotFoundException("No data found for player: " + username);
            }
    
            String[] lines = response.split("\n");

            if (lines.length < skillNames.size()) {
                throw new PlayerNotFoundException("Incomplete hiscore data for: " + username);
            }

            List<Skill> skills = new ArrayList<>();
    
            for (int i = 0; i < skillNames.size(); i++) {
                String[] parts = lines[i].split(",");
                int rank = Integer.parseInt(parts[0]);
                int level = Integer.parseInt(parts[1]);
                int xp = Integer.parseInt(parts[2]);
    
                skills.add(new Skill(skillNames.get(i), rank, level, xp));
            }
    
            return skills;

        } catch (Exception e) {
            throw new PlayerNotFoundException("Player not found: " + username);
        }
    }
}
