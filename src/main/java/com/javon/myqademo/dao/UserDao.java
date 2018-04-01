package com.javon.myqademo.dao;

import com.javon.myqademo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

    User findByStudentNo(String studentNo);

    List<User> queryAllByCreateTimeAfter(Date createTime);

    User findByNickName(String nickName);

    void deleteByUserId(Long userId);

    @Query(value = "UPDATE User SET studentNo =?1 and name = ?2 where userId=?3 ", nativeQuery = true)
    @Modifying
    User updateOne(String studentNo, String name, String userId);

}