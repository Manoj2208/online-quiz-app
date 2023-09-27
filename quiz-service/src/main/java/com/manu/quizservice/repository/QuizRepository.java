package com.manu.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.quizservice.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
