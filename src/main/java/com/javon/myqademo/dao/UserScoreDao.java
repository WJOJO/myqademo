package com.javon.myqademo.dao;

import com.javon.myqademo.domain.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreDao extends JpaRepository<UserScore, Long>{

    UserScore findByUserId(Long UserId);


}
