package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity;

import java.util.List;

import com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.Game;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
   

    // @Column(nullable = false, unique = true)
    private String username;

    //@Column(nullable = false, unique = true)
    private String email;


     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Spiel> spiele;

   

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private QuizGame quizGame;

   

    // Konstruktor, Getter und Setter
    // Konstruktor ohne Argumente für JPA
    public User() {
    }

    public User(String username, String email,  String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter und Setter

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public QuizGame getQuizGame() {
        return quizGame;
    }

    public void setQuizGame(QuizGame quizGame) {
        this.quizGame = quizGame;
    }

    public List<Spiel> getSpiele() {
        return spiele;
    }

    public void setSpiele(List<Spiel> spiele) {
        this.spiele = spiele;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ",  email=" + email + "]";
	}
}