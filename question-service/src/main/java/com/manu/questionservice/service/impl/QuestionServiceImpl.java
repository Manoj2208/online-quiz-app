
package com.manu.questionservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.manu.questionservice.dto.QuestionDto;
import com.manu.questionservice.dto.QuestionWrapperDto;
import com.manu.questionservice.dto.ResponseDto;
import com.manu.questionservice.dto.Solution;
import com.manu.questionservice.entity.Question;
import com.manu.questionservice.exception.ResourceConflictExists;
import com.manu.questionservice.exception.ResourceNotFound;
import com.manu.questionservice.repository.QuestionRepository;
import com.manu.questionservice.response.ApiResponse;
import com.manu.questionservice.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public QuestionDto getById(Integer id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Question not found"));
		QuestionDto questionDto = new QuestionDto();
		BeanUtils.copyProperties(question, questionDto, "questionId");

		return questionDto;
	}

	@Override
	public ApiResponse create(QuestionDto questionDto) {
		Optional<Question> question = questionRepository.findByQuestion(questionDto.getQuestion());
		if (question.isPresent()) {
			throw new ResourceConflictExists("Question already exists");

		}

		Question question2 = new Question();
		BeanUtils.copyProperties(questionDto, question2);
		questionRepository.save(question2);
		return new ApiResponse("question created successfully", HttpStatus.CREATED);
	}

//	@Override
//	public List<QuestionWrapper> getQuestions(QuizDto quizDto) {
//		List<Question> questions = questionRepository.getQuestions(quizDto.getCategory(), quizDto.getNoOfQuestions());
//
//		return questions.stream()
//				.map(question -> QuestionWrapper.builder().question(question.getQuestion())
//						.option1(question.getOption1()).option2(question.getOption2()).option3(question.getOption3())
//						.option4(question.getOption4()).questionId(question.getQuestionId()).build())
//				.toList();
//
//	}

	@Override
	public List<Solution> getQuestionsForQuiz(String category, Integer numOfQuestions) {
		// TODO Auto-generated method stub
		List<Integer> questIntegers = questionRepository.getQuestions(category, numOfQuestions);
		List<Solution> solutions = questIntegers.stream().map(i -> Solution.builder().solution(i).build()).toList();
		return solutions;
	}

	@Override
	public List<QuestionWrapperDto> getQuestionsFromId(List<Integer> questionIds) {
		List<Question> questions = questionRepository.findAllById(questionIds);
		return questions.stream()
				.map(question -> QuestionWrapperDto.builder().questionId(question.getQuestionId())
						.question(question.getQuestion()).option1(question.getOption1()).option2(question.getOption2())
						.option3(question.getOption3()).option4(question.getOption4()).build()

				).toList();
	}

	@Override
	public Solution getScore(List<ResponseDto> responseDtos) {
		// TODO Auto-generated method stub
		Integer i = 0;
		for (ResponseDto responseDto : responseDtos) {
			Question question = questionRepository.findById(responseDto.getQuestionId())
					.orElseThrow(() -> new ResourceNotFound(
							String.format("Question with id:%d not found", responseDto.getQuestionId())));
			if (question.getAnswer().equals(responseDto.getResponse())) {
				i++;
			}

		}
		return Solution.builder().solution(i).build();
	}
}
