package com.manu.quizservice.entity;

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
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer responseId;
	private Integer questionId;
	private String response;

}
