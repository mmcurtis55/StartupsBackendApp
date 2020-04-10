package com.example.StartupsBackendApp;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Game {

    private final String identifier = UUID.randomUUID().toString();
    private ArrayList<String> players;
    private GameStatus status;


    @JsonCreator
    public Game(@JsonProperty("players") String players){
        this.players = new ArrayList<>(Arrays.asList(players.split(",")));
        this.status = GameStatus.NOT_STARTED;
    }

    public void startGame(){
        this.status = GameStatus.IN_PLAY;
    }

    public void finishGame(){
        this.status =  GameStatus.FINISHED;
    }

    public void addPlayer(String player){
        this.players.add(player);

    }

    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public GameStatus getStatus() {
        return status;
    }
}
