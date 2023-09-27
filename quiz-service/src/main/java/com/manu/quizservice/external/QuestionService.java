package com.manu.quizservice.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.manu.quizservice.config.CustomFeignClientConfiguration;
import com.manu.quizservice.dto.QuestionWrapperDto;
import com.manu.quizservice.dto.ResponseDto;
import com.manu.quizservice.dto.Solution;

@FeignClient(name = "question-service", configuration = CustomFeignClientConfiguration.class)
public interface QuestionService {

	@GetMapping("/questions/quiz")
	ResponseEntity<List<Solution>> getQuestionsForQuiz(@RequestParam String category,
			@RequestParam Integer numOfQuestions);

	@PostMapping("/questions/quiz")
	ResponseEntity<List<QuestionWrapperDto>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

	@PostMapping("/questions/response")
	ResponseEntity<Solution> getScore(@RequestBody List<ResponseDto> responseDtos);
}
