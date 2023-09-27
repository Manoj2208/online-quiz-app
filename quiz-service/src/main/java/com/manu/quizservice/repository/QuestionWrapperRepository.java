package com.manu.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.quizservice.entity.QuestionWrapper;

public interface QuestionWrapperRepository extends JpaRepository<QuestionWrapper,Long>{

}
