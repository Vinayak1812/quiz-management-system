package com.quiz.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.QuizDet;

@Repository
public interface QuestionRepo extends JpaRepository<QuizDet, Integer> {

}
