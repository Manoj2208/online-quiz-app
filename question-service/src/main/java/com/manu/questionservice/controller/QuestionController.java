package com.manu.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manu.questionservice.dto.QuestionDto;
import com.manu.questionservice.dto.QuestionWrapperDto;
import com.manu.questionservice.dto.ResponseDto;
import com.manu.questionservice.dto.Solution;
import com.manu.questionservice.response.ApiResponse;
import com.manu.questionservice.service.QuestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@PostMapping
	ResponseEntity<ApiResponse> create(@RequestBody @Valid QuestionDto questionDto) {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.create(questionDto));

	}

	@GetMapping("/{id}")
	ResponseEntity<QuestionDto> getById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(questionService.getById(id));

	}

	@GetMapping("/quiz")
	ResponseEntity<List<Solution>> getQuestionsForQuiz(@RequestParam String category,
			@RequestParam Integer numOfQuestions) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(questionService.getQuestionsForQuiz(category, numOfQuestions));

	}

	@PostMapping("/quiz")
	ResponseEntity<List<QuestionWrapperDto>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
		return ResponseEntity.status(HttpStatus.FOUND).body(questionService.getQuestionsFromId(questionIds));

	}
	
	@PostMapping("/response")
	ResponseEntity<Solution> getScore(@RequestBody List<ResponseDto> responseDtos){
		return ResponseEntity.status(HttpStatus.FOUND).body(questionService.getScore(responseDtos));
	}

}
