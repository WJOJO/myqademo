package com.javon.myqademo.controller;

import com.javon.myqademo.dao.QuestionDao;
import com.javon.myqademo.domain.Question;
import com.javon.myqademo.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Random;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
    public Question[] getQuestion(){
        int page = new Random().nextInt(5) + 1;
        Question[] myQuestions = new Question[20];
        Sort sort = new Sort(Sort.Direction.ASC, "questionId");
        Pageable pageable = new PageRequest(page,20,sort);
        Page<Question> questions = questionDao.queryAllBy(pageable);
        Iterator<Question> it = questions.iterator();
        int[] paramArray = RandomUtils.getRandomQuestion(20);
        int i = 0;
        while(it.hasNext()){
            myQuestions[paramArray[i] - 1] = it.next();
            i ++;
        }
        return myQuestions;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(5));
        }
    }


}
