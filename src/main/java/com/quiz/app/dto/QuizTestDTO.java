package com.quiz.app.dto;

public class QuizTestDTO {

	private int questionId;

    private String question;

    private String typeOfQuestion; // multiple ans, radio, description

    private String answer;

    private int score;

    private int punishment;

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

	@Override
	public String toString() {
		return "QuizTestDTO [questionId=" + questionId + ", question=" + question + ", typeOfQuestion=" + typeOfQuestion
				+ ", answer=" + answer + ", score=" + score + ", punishment=" + punishment + "]";
	}

	public QuizTestDTO(int questionId, String question, String typeOfQuestion, String answer, int score,
			int punishment) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.typeOfQuestion = typeOfQuestion;
		this.answer = answer;
		this.score = score;
		this.punishment = punishment;
	}

	public QuizTestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
