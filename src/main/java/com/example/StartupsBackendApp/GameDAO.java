package com.example.StartupsBackendApp;

import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class GameDAO {

    private static HashMap<String,Game> games = new HashMap<>();

    static {
        Game game1 = new Game("Greg,Tim,Miles");
        Game game2 =new Game("Tamia,Wako,Miles");
        Game game3 = new Game("William,Tim,Knoles");

        games.put(game1.getIdentifier(), game1);
        games.put(game2.getIdentifier(), game2);
        games.put(game3.getIdentifier(), game3);

    }

    public Set<Map.Entry<String, Game>> getGames(){
        return games.entrySet();
    }

    public Game getGameById(String id){
        return games.get(id);
    }

    public Game addGame(Game newGame){
        games.put(newGame.getIdentifier(), newGame);
        return newGame;
    }
}
