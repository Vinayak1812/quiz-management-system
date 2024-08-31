package com.quiz.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuizDTO;
import com.quiz.app.dto.QuizQuestionDTO;
import com.quiz.app.entity.Quiz;
import com.quiz.app.entity.QuizDet;
import com.quiz.app.repo.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public void addMultipleQuizzes(List<QuizDTO> quizDTO) {
		// TODO Auto-generated method stub
		
		List<Quiz> quizEntities = quizDTO.stream().map(quizes->{
			Quiz quiz = new Quiz();
			quiz.setTitle(quizes.getTitle());
			quiz.setDescription(quizes.getDescription());
			return quiz;
		}).collect(Collectors.toList());
		
		quizRepository.saveAll(quizEntities);
	}

	@Override
	public QuizQuestionDTO getQuestionsByQuizId(int quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
		
		QuizQuestionDTO quizQuestionDTO = new QuizQuestionDTO();
		quizQuestionDTO.setQuizTitle(quiz.getTitle());
		
		List<String> questions = quiz.getQuestions().stream().map(QuizDet::getQuestion).collect(Collectors.toList());
				
		quizQuestionDTO.setQuestions(questions);
		
		return quizQuestionDTO;
	}

}
