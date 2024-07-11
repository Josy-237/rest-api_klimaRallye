package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizbilder")
public class QuizBild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // oder byte[] für das Bild selbst, je nach Speicherung

    @ManyToOne
    private QuizFrage frage;

    // Konstruktoren, Getter und Setter

    public QuizBild() {
    }

    public QuizBild(String url, QuizFrage frage) {
        this.url = url;
        this.frage = frage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public QuizFrage getFrage() {
        return frage;
    }

    public void setFrage(QuizFrage frage) {
        this.frage = frage;
    }
}