package com.quiz.app.dto;

public class QuizDTO {

	private String title;
	private String description;
	
	public QuizDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public QuizDTO() {
		super();
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
	@Override
	public String toString() {
		return "QuizDTO [title=" + title + ", description=" + description + "]";
	} 
	
	
}
