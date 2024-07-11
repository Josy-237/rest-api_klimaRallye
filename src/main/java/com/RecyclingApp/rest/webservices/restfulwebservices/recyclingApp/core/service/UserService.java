package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.Game;
import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity.User;

@Service
public class UserService {
    
    
    private static List<User> users = new ArrayList<>();

	public List<User> findByUsername(String username) {
		Predicate<? super User> predicate = user -> user.getUsername().equalsIgnoreCase(username);
		return users.stream().filter(predicate).toList();
	}

	public User addUser(String username, String email, String password) {
		User user = new User(username, email,password);
		users.add(user);
		return user;
	}

	public void deleteUserById(Long id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}

	public User findUserById(Long id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		User user = users.stream().filter(predicate).findFirst().get();
		return user;
	}

	public void updateUser(User user) {
		deleteUserById(user.getId());
		users.add(user);
	}
    
}
