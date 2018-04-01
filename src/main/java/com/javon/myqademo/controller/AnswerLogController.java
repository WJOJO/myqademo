package com.javon.myqademo.controller;

import com.javon.myqademo.dao.AnswerLogDao;
import com.javon.myqademo.domain.AnswerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/log")
@RestController
public class AnswerLogController {

    @Autowired
    AnswerLogDao answerLogDao;

    public List<AnswerLog> queryByUserId(Long userID){
        return answerLogDao.queryAllByUserId(userID);
    }

}
