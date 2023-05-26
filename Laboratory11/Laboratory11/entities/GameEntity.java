package com.compulsory.Laboratory11.entities;

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

    public void addPlayer(PlayerEntity player) {
        this.players.add(player);
    }


}
