package com.quiz.app.service;

import java.util.List;

import com.quiz.app.dto.QuizTestDTO;

public interface TestService {

	public List<QuizTestDTO> getTestQuestionsByQuizId(int quizId);

}
