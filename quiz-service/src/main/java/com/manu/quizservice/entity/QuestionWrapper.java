package com.manu.quizservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionWrapper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

}
