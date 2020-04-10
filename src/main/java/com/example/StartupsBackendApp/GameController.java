package com.example.StartupsBackendApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameDAO gameDAO;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Set<Map.Entry<String, Game>>> getAllGames() {

        if (!gameDAO.getGames().isEmpty()) {
            return new ResponseEntity<Set<Map.Entry<String, Game>>>(gameDAO.getGames(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Set<Map.Entry<String, Game>>>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path="/{identifier}", produces = "application/json")
    public ResponseEntity<Game> getGame(@PathVariable String identifier) {
        Game game = gameDAO.getGameById(identifier);

        if (game != null) {
            return ResponseEntity.ok(game);
        } else {
            return  ResponseEntity.notFound().build();
        }

    }

    @PostMapping( consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createNewGame(
            @RequestBody Game game) throws Exception
    {
        gameDAO.addGame(game);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{identifier}")
                .buildAndExpand(game.getIdentifier())
                .toUri();

        return ResponseEntity.created(location).body(game);
    }

    @PostMapping(
            value = "/createGame", consumes = "application/json", produces = "application/json")
    public Game createGame(@RequestBody Game game) {
        return gameDAO.addGame(game);
    }

//    @PostMapping(
//            value = "/updatePerson", consumes = "application/json", produces = "application/json")
//    public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
//        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/findPerson/" + person.getId()).toUriString());
//
//        return personService.saveUpdatePerson(person);
//    }


}
