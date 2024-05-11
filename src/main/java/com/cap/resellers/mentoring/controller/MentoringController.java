package com.cap.resellers.mentoring.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.dto.response.GetQuestionResponse;
import com.cap.resellers.mentoring.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MentoringController {
    @GetMapping("/question")
    public ApiResponse<ApiResponse.CustomBody<GetQuestionResponse>> getQuestion() {
        HashMap<Integer, String> quest = new LinkedHashMap<>();
        Arrays.stream(Question.values()).forEach(question ->
            quest.put(question.getNumber(), question.getQuestion()));
        GetQuestionResponse getQuestionResponse = GetQuestionResponse.of(quest);
        return ApiResponseGenerator.success(getQuestionResponse, HttpStatus.OK);
    }
}


