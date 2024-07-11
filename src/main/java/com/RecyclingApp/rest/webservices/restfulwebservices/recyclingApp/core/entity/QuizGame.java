package com.RecyclingApp.rest.webservices.restfulwebservices.recyclingApp.core.entity;


import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("quiz")
public class QuizGame extends Spiel {

    private int quizQuestions;
    private int correctAnswers;

    @OneToMany(mappedBy = "quizGame")
    private List<QuizFrage> fragen;

    // Konstruktoren, Getter und Setter

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public QuizGame() {
        super();
    }

    public QuizGame(String description, boolean done, int points, boolean success, User user, int quizQuestions, int correctAnswers) {
        super(description, done, points, success, user);
        this.quizQuestions = quizQuestions;
        this.correctAnswers = correctAnswers;
    }

    public int getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(int quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuizFrage> getFragen() {
        return fragen;
    }

    public void setFragen(List<QuizFrage> fragen) {
        this.fragen = fragen;
    }

    @Override
    public String toString() {
        return "QuizGame{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", done=" + isDone() +
                ", points=" + getPoints() +
                ", success=" + isSuccess() +
                ", user=" + (getUser() != null ? getUser().getUsername() : null) +
                ", quizQuestions=" + quizQuestions +
                ", correctAnswers=" + correctAnswers +
                ", fragen=" + fragen +
                '}';
    }
}
