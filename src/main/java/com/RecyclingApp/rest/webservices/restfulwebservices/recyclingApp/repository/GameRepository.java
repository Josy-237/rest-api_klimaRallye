package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.Game;

public interface GameRepository extends JpaRepository <Game, Integer>{

    List<Game> findByUsername(String username);
    
}
