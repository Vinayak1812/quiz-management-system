package com.quiz.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.UserDTO;
import com.quiz.app.dto.UserInfoDTO;
import com.quiz.app.entity.User;
import com.quiz.app.repo.UserInfoRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserInfoRepo userInfoRepo;
	
	@Override
	public boolean getUserByEmail(String email) {
		
		User user = userInfoRepo.getUserByEmail(email);
		
		if(user!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void createUser(UserInfoDTO userInfoDTO) {
		User user = userInfoDTO.toUser();
		
		user.setEmail(userInfoDTO.getEmail());
		user.setName(userInfoDTO.getName());
		user.setPassword(userInfoDTO.getPassword());
		
		userInfoRepo.save(user);
	}
	
	@Override
	public User getUserExist(UserDTO userDTO) {
		 User existingUser = userInfoRepo.getUserExist(userDTO.getEmail(), userDTO.getPassword());
		 
		 if (existingUser != null) {
		        return existingUser;
		    } else {
		        // Optionally, you could handle the case where the user does not exist
		        // For example, you could return null or throw an exception
		        return null;
		    }
	}
}
