package com.github.macylion.bugtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "bugs")
public class Bug {
    @Id private UUID id;
    private String name;
    private String description;
    private int level;
    private boolean isSolved;


    public Bug(String name, String description, int level){
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.level = level;
        this.isSolved = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }
}
