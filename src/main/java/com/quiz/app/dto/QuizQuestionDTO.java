package com.quiz.app.dto;

import java.util.List;

public class QuizQuestionDTO {

	private String quizTitle;
    private List<String> questions;
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public List<String> getQuestions() {
		return questions;
	}
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "QuizQuestionDTO [quizTitle=" + quizTitle + ", questions=" + questions + "]";
	}
	public QuizQuestionDTO(String quizTitle, List<String> questions) {
		super();
		this.quizTitle = quizTitle;
		this.questions = questions;
	}
	public QuizQuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
