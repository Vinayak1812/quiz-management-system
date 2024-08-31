package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.QuizTestDTO;
import com.quiz.app.model.MessageResponse;
import com.quiz.app.service.TestService;

@RestController
@RequestMapping("api/test")
public class TestController {

	@Autowired
	public TestService testService;
	
	// Start test via clicking the quiz 
	@GetMapping("/{quizId}")
	public ResponseEntity<?> giveTest(@PathVariable int quizId){
		try {
			List<QuizTestDTO> quizTestDTO = testService.getTestQuestionsByQuizId(quizId);
			return ResponseEntity.ok(quizTestDTO);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new MessageResponse(1005, "Error getting questions For Test"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	// Marks Update
	
	// Marks Show
	
	// 
}
