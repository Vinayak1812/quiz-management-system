package com.quiz.app.dto;

import com.quiz.app.entity.User;

public class UserInfoDTO {

	private int id;
	private String name;
	private String email;
	private String password;
	
	public User toUser() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
