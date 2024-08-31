package com.quiz.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.QuizDet;

@Repository
public interface TestRepo extends JpaRepository<QuizDet, Integer>{

	@Query("select Q FROM QuizDet Q WHERE Q.quiz.quizId = :quizId")
	public List<QuizDet> findAllByQuizId(int quizId);

	
}
