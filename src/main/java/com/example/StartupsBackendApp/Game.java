package com.example.StartupsBackendApp;

import java.util.ArrayList;

public class Game {

    private final String identifier;
    private final ArrayList<String> players;
    private GameStatus status;

    Game(String identifier, ArrayList players, GameStatus status){
        this.identifier = identifier;
        this.players = players;
        this.status = status;
    }
}
