package com.manu.questionservice.service;

import java.util.List;

import com.manu.questionservice.dto.QuestionDto;
import com.manu.questionservice.dto.QuestionWrapperDto;
import com.manu.questionservice.dto.ResponseDto;
import com.manu.questionservice.dto.Solution;
import com.manu.questionservice.response.ApiResponse;

public interface QuestionService {
	QuestionDto getById(Integer id);

	ApiResponse create(QuestionDto questionDto);

	List<Solution> getQuestionsForQuiz(String category, Integer numOfQuestions);

	List<QuestionWrapperDto> getQuestionsFromId(List<Integer> questionIds);

	Solution getScore(List<ResponseDto> responseDtos);

}
