package com.javon.myqademo.controller;

import com.javon.myqademo.dao.QuestionDao;
import com.javon.myqademo.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
    public Page<Question> getQuestion(){
        Sort sort = new Sort(Sort.Direction.ASC, "questionId");
        Pageable pageable = new PageRequest(1,20,sort);
        Page<Question> questions = questionDao.queryAllBy(pageable);
        return questions;
    }

}
