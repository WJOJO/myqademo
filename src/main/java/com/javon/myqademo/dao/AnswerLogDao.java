package com.javon.myqademo.dao;

import com.javon.myqademo.domain.AnswerLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerLogDao extends JpaRepository<AnswerLog, Long> {

    List<AnswerLog> queryAllByUserId(Long userId);

    List<AnswerLog> queryAllBy();
}
