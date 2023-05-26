package com.homework11.Client.Homework11Client.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameEntity {

    String gameName;
    String id;
    List<PlayerEntity> players;

    public GameEntity(String gameName, String id) {
        this.gameName = gameName;
        this.id = id;
        players = new ArrayList<>();
    }

    public GameEntity() {
    }

    public void addPlayer(PlayerEntity player) {
        this.players.add(player);
    }

    public String getGameName() {
        return gameName;
    }
}
