package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity.User;
import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.repository.UserRepository;
import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.service.UserService;

// in dieser klasse wird die jpa version der Users implementiert

@RestController
@RequestMapping("/benutzer")
public class UserController {

private UserService userService;
private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

        @GetMapping("/liste")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/list")
    public List<User> getUsers(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String username, @PathVariable Long id ) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserByName(@PathVariable Long id ) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user.getUsername(), user.getEmail(), user.getPassword());
    }



    // @PutMapping("/{id}")
    // public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    //     Optional<User> optionalUser = userService.findUserById(id);
    //     if (optionalUser.isPresent()) {
    //         User user = optionalUser.get();
    //         user.setUsername(userDetails.getUsername());
    //         user.setEmail(userDetails.getEmail());
    //         final User updatedUser = userService.updateUser(user);
    //         return ResponseEntity.ok(updatedUser);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    
}
