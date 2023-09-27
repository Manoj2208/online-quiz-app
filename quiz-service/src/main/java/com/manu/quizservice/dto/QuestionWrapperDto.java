package com.manu.quizservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapperDto {
	private Integer questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

}
