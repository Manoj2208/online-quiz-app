package com.manu.quizservice.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.manu.quizservice.dto.QuestionWrapperDto;
import com.manu.quizservice.dto.QuizDto;
import com.manu.quizservice.dto.ResponseDto;
import com.manu.quizservice.dto.Solution;
import com.manu.quizservice.entity.Quiz;
import com.manu.quizservice.exception.ResourceNotFound;
import com.manu.quizservice.external.QuestionService;
import com.manu.quizservice.repository.QuizRepository;
import com.manu.quizservice.response.ApiResponse;
import com.manu.quizservice.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepository;

	@Autowired
	QuestionService questionService;

	@Override
	public ApiResponse createQuiz(QuizDto quizDto) {
		List<Solution> solutions = questionService
				.getQuestionsForQuiz(quizDto.getCategory(), quizDto.getNoOfQuestions()).getBody();
		// List<QuestionWrapper> questionWrappers = questions.getBody();
		List<Integer> questionIds=solutions.stream().map(Solution::getSolution).collect(Collectors.toList());
		Quiz quiz = Quiz.builder().category(quizDto.getCategory()).title(quizDto.getTitle()).questionIds(questionIds)
				.build();
		quizRepository.save(quiz);

		return new ApiResponse("Quiz created successfully", HttpStatus.CREATED);
	}

	@Override
	public List<QuestionWrapperDto> getQuizQuestions(Long id) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new ResourceNotFound("quiz not found"));
		return questionService.getQuestionsFromId(quiz.getQuestionIds()).getBody();
	}

	@Override
	public ApiResponse getScore(List<ResponseDto> responseDtos) {
		Solution solution = questionService.getScore(responseDtos).getBody();

		return new ApiResponse(String.format("score:%d", solution.getSolution()), HttpStatus.OK);
	}

}
