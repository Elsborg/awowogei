package com.martinelsborg.awowogei.model;

public class Skill {
    private String name;
    private int rank;
    private int level;
    private int experience;

    public Skill(String name, int rank, int level, int experience) {
        this.name = name;
        this.rank = rank;
        this.level = level;
        this.experience = experience;
    }

    public String getName() { return name; }
    public int getRank() { return rank; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }

}
