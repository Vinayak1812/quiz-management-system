package com.quiz.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.dto.QuizDTO;
import com.quiz.app.dto.QuizQuestionDTO;
import com.quiz.app.model.MessageResponse;
import com.quiz.app.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

	@Autowired
	public QuizService quizService;
	
	// Add the Quiz type
	@PostMapping("/addquiz")
	public ResponseEntity<?> createQuizType(@RequestBody List<QuizDTO> quizDTO) {

		try {
			quizService.addMultipleQuizzes(quizDTO);
			return ResponseEntity.ok(new MessageResponse(2003, "Quizzes added successfully!"));
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageResponse(1003, "Error adding quizzes"), HttpStatus.BAD_REQUEST);
		}
	}
	// Get the Questions from perticular quiz
	@GetMapping("/{quizId}/getquestion")
	public ResponseEntity<?> getQuestionByQuizId(@PathVariable int quizId){
		try {
			QuizQuestionDTO quizQuestionsDTO = quizService.getQuestionsByQuizId(quizId);
	        return ResponseEntity.ok(quizQuestionsDTO);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new MessageResponse(1004, "Error getting questions"), HttpStatus.BAD_REQUEST);
		}
	}

	// delete the Quiz type with all it's questions //  Delete a Question with 

	// Modify the Quiz name or other

}
