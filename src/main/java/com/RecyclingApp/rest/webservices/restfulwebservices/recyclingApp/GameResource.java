package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//@RestController
public class GameResource {

    private GameService gameService;

    public GameResource(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("users/{username}/games")
    public List<Game> getGames(@PathVariable String username){
        return gameService.findByUsername(username);
    }

    @GetMapping("/users/{username}/games/{id}")
    public Game getGame(@PathVariable String username, @PathVariable int id ) {
        return gameService.findById(id);
    }

    @DeleteMapping("/users/{username}/games/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable int id ) {
         gameService.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }

}
