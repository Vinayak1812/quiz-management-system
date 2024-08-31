package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.QuestionsDTO;
import com.quiz.app.model.MessageResponse;
import com.quiz.app.service.QuestionService;
import com.quiz.app.utils.AppConstants;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	public QuestionService questionService;
	
	// Add the quiz Questions
	@PostMapping("/addquestions")
	public ResponseEntity<?> addQuestions(@RequestBody List<QuestionsDTO> questionDTO){
		try {
			questionService.addQuestions(questionDTO);
			return ResponseEntity.ok(new MessageResponse(2005, AppConstants.SUCC2005));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return new ResponseEntity<MessageResponse>(new MessageResponse(1012, AppConstants.ERROR1012),
					HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<MessageResponse>(new MessageResponse(1011, AppConstants.ERROR1011),
					HttpStatus.BAD_REQUEST);
		}
	}
	// Modify the question or Answer
	
	
	// Get question via it's id
	
	
}
