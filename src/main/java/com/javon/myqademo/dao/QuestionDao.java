package com.javon.myqademo.dao;

import com.javon.myqademo.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long>{

    Question findByQuestionId(Long questionId);

    @Query("select questionId from Question q")
    List<Long> findIds();

    Page<Question> queryAllBy(Pageable pageable);

}
