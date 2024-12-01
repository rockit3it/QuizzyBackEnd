package com.Ritesh.QuiZZAppFinal.controller;

import com.Ritesh.QuiZZAppFinal.entity.QuiZZyQuestion;
import com.Ritesh.QuiZZAppFinal.service.QuiZZyQuestionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/QuiZZy/api")
public class QuiZZyController {
    private final QuiZZyQuestionService questionService;

    public QuiZZyController(QuiZZyQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/getQuestion")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<QuiZZyQuestion> getQuestion() {
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public QuiZZyQuestion saveQuestion(@RequestBody QuiZZyQuestion question) {
        return questionService.addQuestion(question);
    }
}