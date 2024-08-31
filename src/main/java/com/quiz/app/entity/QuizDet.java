package com.quiz.app.entity;

//import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "quiz_detail")
public class QuizDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int questionId;

    private String question;

    private String typeOfQuestion; // multiple ans, radio, description

    private String answer;

    private int score;

    private int punishment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizid", nullable = false)
    private Quiz quiz;

    // Constructors
    public QuizDet() {
        super();
    }

    public QuizDet(int questionId, String question, String typeOfQuestion, String answer, int score, int punishment) {
        super();
        this.questionId = questionId;
        this.question = question;
        this.typeOfQuestion = typeOfQuestion;
        this.answer = answer;
        this.score = score;
        this.punishment = punishment;
    }

    // Getters and Setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTypeOfQuestion() {
        return typeOfQuestion;
    }

    public void setTypeOfQuestion(String typeOfQuestion) {
        this.typeOfQuestion = typeOfQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPunishment() {
        return punishment;
    }

    public void setPunishment(int punishment) {
        this.punishment = punishment;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "QuizDet [questionId=" + questionId + ", question=" + question + ", typeOfQuestion=" + typeOfQuestion
                + ", answer=" + answer + ", score=" + score + ", punishment=" + punishment + "]";
    }
}
