package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.repository.GameRepository;

// in dieser klasse wird die jpa version des game services implementiert

@RestController
public class GameJpaResource {

private GameService gameService;
private GameRepository gameRepository;

    public GameJpaResource(GameService gameService, GameRepository gameRepository){
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    @GetMapping("users/{username}/games")
    public List<Game> getGames(@PathVariable String username){
        return gameRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/games/{id}")
    public Game getGame(@PathVariable String username, @PathVariable int id ) {
        return gameRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/games/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String username,@PathVariable int id ) {
        gameRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/games/{id}")
    public Game updateGame(@PathVariable String username, @PathVariable int id, @RequestBody Game game ) {
         //todoService.updateTodo(todo);
         gameRepository.save(game);
        return game;

        
    }
    
}
