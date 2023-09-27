package com.manu.quizservice.service;

import java.util.List;

import com.manu.quizservice.dto.QuestionWrapperDto;
import com.manu.quizservice.dto.QuizDto;
import com.manu.quizservice.dto.ResponseDto;
import com.manu.quizservice.response.ApiResponse;

public interface QuizService {
	ApiResponse createQuiz(QuizDto quizDto);

	List<QuestionWrapperDto> getQuizQuestions(Long id);

	ApiResponse getScore(List<ResponseDto> responseDtos);
}
