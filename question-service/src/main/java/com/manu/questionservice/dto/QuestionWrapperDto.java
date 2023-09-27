package com.manu.questionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionWrapperDto {
	private Integer questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;

}
