package com.quiz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.PasswordRequest;
import com.quiz.app.dto.UserDTO;
import com.quiz.app.dto.UserInfoDTO;
import com.quiz.app.entity.User;
import com.quiz.app.model.MessageResponse;
import com.quiz.app.service.EmailService;
import com.quiz.app.service.UserService;
import com.quiz.app.utils.AppConstants;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public EmailService emailService;

	// Sign up user
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody UserInfoDTO userInfoDTO) {
		try {
			String email = userInfoDTO.getEmail();

			boolean flag = userService.getUserByEmail(email);

			if(flag) {
				return new ResponseEntity<MessageResponse>(new MessageResponse(1002, AppConstants.ERROR1002),
						HttpStatus.BAD_REQUEST);
			} else {
				userService.createUser(userInfoDTO);
				return ResponseEntity.ok(new MessageResponse(2001, AppConstants.SUCC2001));
			}

		} catch (Exception e) {
			// TODO: handle exception
//			logger.error("Error creating user", e);
			return new ResponseEntity<MessageResponse>(new MessageResponse(1001, AppConstants.ERROR1001),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Sign in user
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
		try {

			String email = userDTO.getEmail();
			String password = userDTO.getPassword();

//			UserInfoDTO user = userService.getUserExist(email, password);
			User user = userService.getUserExist(userDTO);

			if (!(user == null)) {
				return ResponseEntity.ok(user);
			} else {
				return new ResponseEntity<>(new MessageResponse(1007, AppConstants.ERROR1007), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// System.out.println(e.printStackTrace());
			return new ResponseEntity<>(new MessageResponse(1008, AppConstants.ERROR1008), HttpStatus.BAD_REQUEST);
		}
	}

//	// delete User
//	@PostMapping("/deleteUser")
//	public ResponseEntity<?> deleteUser() {
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	// update user : password or mail
	@PostMapping("/forgetPassword/genPassEmail")
	public ResponseEntity<?> passForgotGenEmail(@RequestBody PasswordRequest passwordRequest){
		try {
			String email = passwordRequest.getEmail();
			
			if(userService.getUserByEmail(email)) {
				System.out.println("got email "+email);
				boolean result = emailService.sendSimpleMail(passwordRequest.getEmail());
				
				if(result) {
//					String msg = "Password Sent Successfull";
//					return  ResponseEntity.ok(msg);
					return new ResponseEntity<>(new MessageResponse(2002, AppConstants.SUCC2002), HttpStatus.OK);

				}else {
					return new ResponseEntity<>(new MessageResponse(1010, AppConstants.ERROR1010), HttpStatus.SERVICE_UNAVAILABLE);
				}
			}else {
				return new ResponseEntity<MessageResponse>(new MessageResponse(1009, AppConstants.ERROR1009),
						HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new MessageResponse(1010, AppConstants.ERROR1010), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	//
}
