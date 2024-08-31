package com.quiz.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
