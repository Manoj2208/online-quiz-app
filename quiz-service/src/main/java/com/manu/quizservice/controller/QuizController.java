package com.manu.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manu.quizservice.dto.QuestionWrapperDto;
import com.manu.quizservice.dto.QuizDto;
import com.manu.quizservice.dto.ResponseDto;
import com.manu.quizservice.response.ApiResponse;
import com.manu.quizservice.service.QuizService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;

	@PostMapping
	ResponseEntity<ApiResponse> createQuiz(@RequestBody @Valid QuizDto quizDto) {
		return ResponseEntity.status(HttpStatus.OK).body(quizService.createQuiz(quizDto));

	}

	@GetMapping("/{id}")
	ResponseEntity<List<QuestionWrapperDto>> getQuizQuestions(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizQuestions(id));
	}

	@GetMapping("/response")
	ResponseEntity<ApiResponse> getScore(@RequestBody List<ResponseDto> responseDtos) {
		return ResponseEntity.status(HttpStatus.OK).body(quizService.getScore(responseDtos));

	}

}
