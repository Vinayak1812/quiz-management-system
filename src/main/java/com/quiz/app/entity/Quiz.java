package com.quiz.app.entity;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int quizId;
    
    private String title;
    
    private String description;
    
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizDet> questions = new ArrayList<>();

    // Constructors
    public Quiz() {
        super();
    }

    public Quiz(int quizId, String title, String description) {
        super();
        this.quizId = quizId;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuizDet> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizDet> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz [quizId=" + quizId + ", title=" + title + ", description=" + description + "]";
    }
}
