package com.compulsory.Laboratory11.controllers;

/**
 * @author Pal Alexandra
 * This class implements a controller for obtaining the list of the registered players and games via HTTP GET request.
 */

import com.compulsory.Laboratory11.entities.GameEntity;
import com.compulsory.Laboratory11.entities.PlayerEntity;
import com.compulsory.Laboratory11.others.Provider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/serverData")
public class AppController {
    private List<GameEntity> games;
    private List<PlayerEntity> players;

    public AppController() {
        players = Provider.createPlayers();
        games = Provider.createGames(players);
    }

    @GetMapping("/games")
    public List<GameEntity> getGames() {
        return games;
    }

    @GetMapping("/players")
    public List<PlayerEntity> getPlayers() {
        return players;
    }

}
