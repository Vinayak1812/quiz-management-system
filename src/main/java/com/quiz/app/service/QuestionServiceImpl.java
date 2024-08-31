package com.quiz.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.dto.QuestionsDTO;
import com.quiz.app.entity.Quiz;
import com.quiz.app.entity.QuizDet;
import com.quiz.app.repo.QuestionRepo;
import com.quiz.app.repo.QuizRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
    private QuizRepository quizRepository;

	@Override
	public void addQuestions(List<QuestionsDTO> questionDTO) {
		// TODO Auto-generated method stub
		
		List<QuizDet> questionEntities = questionDTO.stream().map(question->{
			QuizDet ques = new QuizDet();
			ques.setQuestion(question.getQuestion());
			ques.setAnswer(question.getAnswer());
			ques.setScore(question.getScore());
			ques.setPunishment(question.getPunishment());
			ques.setTypeOfQuestion(question.getTypeOfQuestion());
			
			Quiz quiz = quizRepository.findById(question.getQuizId()).orElseThrow(() -> new RuntimeException("Quiz not found"));
			ques.setQuiz(quiz);
			return ques;
			
		}).collect(Collectors.toList());
		
		questionRepo.saveAll(questionEntities);
		
	}

	

}
