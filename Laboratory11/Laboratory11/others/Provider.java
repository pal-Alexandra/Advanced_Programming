package com.compulsory.Laboratory11.others;
/**
 * @author Pal Alexandra
 * This class is used to create some games and players.
 */

import com.compulsory.Laboratory11.entities.GameEntity;
import com.compulsory.Laboratory11.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class Provider {

    static List<GameEntity> games;
    static List<PlayerEntity> players;

    public static List<GameEntity> createGames(List<PlayerEntity> players) {
        games = new ArrayList<>();
        GameEntity game1 = new GameEntity("Game_1", "g1");
        game1.addPlayer(players.get(0));
        game1.addPlayer(players.get(1));
        games.add(game1);

        GameEntity game2 = new GameEntity("Game_2", "g2");
        game2.addPlayer(players.get(2));
        game2.addPlayer(players.get(3));
        games.add(game2);

        return games;
    }

    public static List<PlayerEntity> createPlayers() {
        players = new ArrayList<>();
        PlayerEntity player1 = new PlayerEntity("Player1", "p1");
        players.add(player1);
        PlayerEntity player2 = new PlayerEntity("Player2", "p2");
        players.add(player2);
        PlayerEntity player3 = new PlayerEntity("Player3", "p3");
        players.add(player3);
        PlayerEntity player4 = new PlayerEntity("Player4", "p4");
        players.add(player4);
        return players;
    }

}
