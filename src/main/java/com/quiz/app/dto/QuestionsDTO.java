package com.quiz.app.dto;

import com.quiz.app.entity.QuizDet;

public class QuestionsDTO {

	private String question;
	private String typeOfQuestion;
	private String answer;
	private int score;
	private int punishment;
	private int quizId;
	
	
	
//	public QuizDet toQuizDet() {
//		QuizDet quizDet = new QuizDet();
//		quizDet.setTypeOfQuestion(getTypeOfQuestion());
//		quizDet.setQuestion(getQuestion());
//		quizDet.setAnswer(getAnswer());
//		quizDet.setScore(getScore());
//		quizDet.setPunishment(getPunishment());
//		
//		return quizDet;
//	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "QuestionsDTO [question=" + question + ", typeOfQuestion=" + typeOfQuestion + ", answer=" + answer
				+ ", score=" + score + ", punishment=" + punishment + ", quizId=" + quizId + "]";
	}

	public QuestionsDTO(String question, String typeOfQuestion, String answer, int score, int punishment, int quizId) {
		super();
		this.question = question;
		this.typeOfQuestion = typeOfQuestion;
		this.answer = answer;
		this.score = score;
		this.punishment = punishment;
		this.quizId = quizId;
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

	

	public QuestionsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
