package com.campusland.entities.ActorType.domain;

public class ActorType {
    private int id;
    private String description;
    
    
    public ActorType() {}

    public ActorType(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
