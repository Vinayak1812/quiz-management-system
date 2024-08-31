package com.quiz.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuizTestDTO;
import com.quiz.app.entity.QuizDet;
import com.quiz.app.repo.TestRepo;

@Service
public class TestServiceImpl implements TestService {

	
	
	@Autowired
	public TestRepo testRepo;
	
	
	
	@Override
	public List<QuizTestDTO> getTestQuestionsByQuizId(int quizId) {
		// TODO Auto-generated method stub
		List<QuizDet> questions = testRepo.findAllByQuizId(quizId); 
		
		System.out.println(questions);
		List<QuizTestDTO> quizQuestions = questions.stream().map(question->{
			QuizTestDTO dto = new QuizTestDTO();
            dto.setQuestionId(question.getQuestionId());
            dto.setQuestion(question.getQuestion());
            dto.setTypeOfQuestion(question.getTypeOfQuestion());
            dto.setAnswer(question.getAnswer());
            dto.setScore(question.getScore());
            dto.setPunishment(question.getPunishment());
            
            return dto;
			
		}).collect(Collectors.toList());
		
		return quizQuestions;
	}

}
