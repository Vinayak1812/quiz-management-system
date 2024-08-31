package com.quiz.app.service;

import com.quiz.app.dto.UserDTO;
import com.quiz.app.dto.UserInfoDTO;
import com.quiz.app.entity.User;


public interface UserService {
	
	public boolean getUserByEmail(String email);

	public void createUser(UserInfoDTO userInfoDTO);

//	public UserInfoDTO getUserExist(String email, String password);
	public User getUserExist(UserDTO userDTO);

	
	
}
