package com.homework11.Client.Homework11Client;

/**
 * @author Pal Alexandra
 * This class is used to invoke the services implemented in the first two requirements of the homework
 */

import com.homework11.Client.Homework11Client.entities.GameEntity;
import com.homework11.Client.Homework11Client.entities.PlayerEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Component
public class Client implements CommandLineRunner {

    final String playersUri = "http://localhost:8085/serverPlayers";
    final String gamesUri = "http://localhost:8085/serverGames";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void run(String... args) throws Exception {

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        invokeGetPlayers();
        invokeGetGames();
//        invokeAddNewPlayer();
//        invokeUpdatePlayer();
        invokeDeletePlayer();
    }

    public void invokeGetPlayers() {

        //get the players list
        String getPlayersUri = playersUri + "/players";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<PlayerEntity>> response = restTemplate.exchange(getPlayersUri,
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<PlayerEntity>>() {});
        List<PlayerEntity> players = response.getBody();
        System.out.println("The players received from server are: ");
        for (PlayerEntity player : players) {
            System.out.println("ID: " + player.getId() + ", Name: " + player.getName());
        }
    }

    public void invokeAddNewPlayer() {
        //add a new player
        String playerNewName = "NEW PLAYER";
        String postPlayersUri = playersUri + "?name=" + playerNewName;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(postPlayersUri,
                HttpMethod.POST,entity, String.class);

        String addPlayerResponse = response.getBody();
        System.out.println(addPlayerResponse);
    }

    public void invokeUpdatePlayer() {

        String playerIdToUpdate = "p4";
        String updatePlayerUrl = playersUri + "/{id}";
        Map<String, String> putParams = new HashMap<>();
        putParams.put("id",playerIdToUpdate);
        PlayerEntity playerUpdated = new PlayerEntity("PLAYER UPDATED",playerIdToUpdate);
        restTemplate.put(updatePlayerUrl,playerUpdated,putParams);
        System.out.println("Player updated successfully.");

    }

    public void invokeDeletePlayer() {
        String playerIdToDelete = "p2";
        String deletePlayerUrl = playersUri + "/{id}";
        restTemplate.delete(deletePlayerUrl, playerIdToDelete);
        System.out.println("Player with id {p2} deleted successfully.");
    }

    public void invokeGetGames() {
        // Get games
        String getGamesUri = gamesUri + "/games";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<GameEntity>> response = restTemplate.exchange(getGamesUri,
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<GameEntity>>() {});
        List<GameEntity> games = response.getBody();
        System.out.println("The games received from server are: ");
        for (GameEntity game : games) {
            System.out.println("ID: " + game.getId() + ", Name: " + game.getGameName());
        }
    }


}
