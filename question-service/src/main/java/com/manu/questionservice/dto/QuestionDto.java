package com.manu.questionservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "only alphabets acceptable")
	private String category;
	@NotNull
	@Column(unique = true)
	private String question;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "only alphabets acceptable")
	private String difficultLevel;
	@NotNull
	private String option1;
	@NotNull
	private String option2;
	@NotNull
	private String option3;
	@NotNull
	private String option4;
	@NotNull
	private String answer;

}
