package com.manu.questionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	private String category;
	private String question;
	private String difficultLevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

}
