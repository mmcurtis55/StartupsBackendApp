package com.example.StartupsBackendApp;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    private final String identifier;
    private final ArrayList<String> players;
    private GameStatus status;

    public Game createNewGame(String identifier, ArrayList players, GameStatus status){
        this.identifier = identifier;
        this.players = players;
        this.status = status;
    }


}
