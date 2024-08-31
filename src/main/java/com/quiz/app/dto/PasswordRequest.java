package com.quiz.app.dto;

public class PasswordRequest {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PasswordRequest [email=" + email + "]";
	}

	public PasswordRequest(String email) {
		super();
		this.email = email;
	}

	public PasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
