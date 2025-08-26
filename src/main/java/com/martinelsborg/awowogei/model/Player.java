package com.martinelsborg.awowogei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int totalLevel;
    private int combatLevel;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String GetUsername() { return username; }
    public void setUsername (String username) { this.username = username; }

    public int getTotalLevel() { return totalLevel; }
    public void setTotalLevel (int totalLevel) { this.totalLevel = totalLevel; }

    public int getCombatLevel() { return combatLevel; }
    public void setCombatLevel(int combatLevel) { this.combatLevel = combatLevel; }
}
