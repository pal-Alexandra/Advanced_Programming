package com.compulsory.Laboratory11.entities;

import lombok.Data;

@Data
public class PlayerEntity {
    String name;
    String id;

    public PlayerEntity(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
