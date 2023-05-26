package com.homework.Homework11.controllers;

/**
 * @author Pal Alexandra
 * This class implements a REST controller containing a method for obtaining the list of the games, via HTTP GET request.
 */

import com.homework.Homework11.entities.GameEntity;
import com.homework.Homework11.others.Provider;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serverGames")
public class GameController {

    List<GameEntity> games;

    public GameController() {
        PlayerController playerController = new PlayerController();
        games = Provider.createGames(playerController.getPlayers());
    }

    @GetMapping("/games")
    @Operation(tags = {"Games"})
    public List<GameEntity> getGames() {
        return games;
    }
}
