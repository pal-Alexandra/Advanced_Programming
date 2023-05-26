package com.homework.Homework11.controllers;

/**
 * @author Pal Alexandra
 * This class implements a REST controller for managing the players.
 */


import com.homework.Homework11.entities.PlayerEntity;
import com.homework.Homework11.others.Provider;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serverPlayers")
public class PlayerController {
    private List<PlayerEntity> players;

    public PlayerController() {
        players = Provider.createPlayers();
    }


    @GetMapping("/players")
    @Operation(tags = {"Players"})
    public List<PlayerEntity> getPlayers() {
        return players;
    }


    @PostMapping
    @Operation(tags = {"Players"})
    public ResponseEntity<String> addNewPlayer(@RequestParam String name) {

        int idCount = 1 + players.size();
        String stringIdCount = Integer.toString(idCount);
        StringBuilder id = new StringBuilder();
        id.append("p");
        id.append(stringIdCount);
        PlayerEntity player = new PlayerEntity(name, id.toString());
        players.add(player);

        return new ResponseEntity<String>("SUCCES. You added a new player. You can check with a GET request.", HttpStatus.OK);

    }

    /**
     * This method updates the name of the player with the specified id.
     * @param id
     * @param name: new name of the player
     * @return
     */
    @PutMapping("/{id}")
    @Operation(tags = {"Players"})
    public ResponseEntity<String> updatePlayer(@PathVariable String id, @RequestParam String name) {

        PlayerEntity player = findPlayerById(id);
        if (player == null) {
            return new ResponseEntity<>("Player not found.", HttpStatus.NOT_FOUND);
        }
        player.setName(name);
        return new ResponseEntity<>("SUCCES. You updated the name of a player.", HttpStatus.OK);
    }

    /**
     * This method deletes the player with the specified id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    @Operation(tags = {"Players"})
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        PlayerEntity player = findPlayerById(id);
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }
        players.remove(player);
        return new ResponseEntity<>("SUCCES. You removed a player.", HttpStatus.OK);
    }

    public PlayerEntity findPlayerById(String id) {
        for (PlayerEntity player : players) {
            if (player.getId().equals(id)) {
                return player;
            }
        }
        return null;
    }


}
