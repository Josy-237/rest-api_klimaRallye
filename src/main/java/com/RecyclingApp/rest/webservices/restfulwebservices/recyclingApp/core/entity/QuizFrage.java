package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizfrage")
public class QuizFrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private boolean korrekteAntwort;

    @ManyToOne
    private QuizGame quizGame;


     @OneToMany(mappedBy = "frage", cascade = CascadeType.ALL)
    private List<QuizBild> bilder;
    // Konstruktoren, Getter und Setter, toString-Methode

    public QuizFrage() {
    }

    public QuizFrage(String text, boolean korrekteAntwort, QuizGame quizGame) {
        this.text = text;
        this.korrekteAntwort = korrekteAntwort;
        this.quizGame = quizGame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isKorrekteAntwort() {
        return korrekteAntwort;
    }

    public void setKorrekteAntwort(boolean korrekteAntwort) {
        this.korrekteAntwort = korrekteAntwort;
    }

    public QuizGame getQuizGame() {
        return quizGame;
    }

    public void setQuizGame(QuizGame quizGame) {
        this.quizGame = quizGame;
    }

    public List<QuizBild> getBilder() {
        return bilder;
    }

    public void setBilder(List<QuizBild> bilder) {
        this.bilder = bilder;
    }

    @Override
    public String toString() {
        return "Frage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", korrekteAntwort=" + korrekteAntwort +
                '}';
    }
}

