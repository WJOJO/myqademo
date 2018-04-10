package com.javon.myqademo.dao;

import com.javon.myqademo.domain.User;
import com.javon.myqademo.domain.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserScoreDao extends JpaRepository<UserScore, Long>{



}
