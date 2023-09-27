package com.manu.questionservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manu.questionservice.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Optional<Question> findByQuestion(String question);

	@Query(value = "SELECT q.question_id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :noOfQuestions", nativeQuery = true)
	List<Integer> getQuestions(String category, Integer noOfQuestions);

}
