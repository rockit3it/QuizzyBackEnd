package com.Ritesh.QuiZZAppFinal.service;

import com.Ritesh.QuiZZAppFinal.entity.QuiZZyQuestion;
import com.Ritesh.QuiZZAppFinal.repo.QuiZZyREpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuiZZyQuestionService {

    @Autowired
    QuiZZyREpo repo;

    public List<QuiZZyQuestion> getAllQuestions() {
        return repo.findAll();
    }

    public QuiZZyQuestion addQuestion(QuiZZyQuestion question) {
        return repo.save(question);
    }
}
