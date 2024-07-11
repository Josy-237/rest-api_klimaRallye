package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
           
    List<User> findByUsername(String username); 
}
