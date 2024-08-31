package com.quiz.app.service;

import java.util.List;


import com.quiz.app.dto.QuizDTO;
import com.quiz.app.dto.QuizQuestionDTO;

public interface QuizService {

	public void addMultipleQuizzes(List<QuizDTO> quizDTO);

	public QuizQuestionDTO getQuestionsByQuizId(int quizId);

}
