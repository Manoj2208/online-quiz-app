package com.manu.quizservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class QuizDto {
	@NotBlank
	private String title;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "category must be alphabets")
	private String category;
	@NotNull
	@Min(value = 5)
	private Integer noOfQuestions;

}
