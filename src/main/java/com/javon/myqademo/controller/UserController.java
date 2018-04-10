package com.javon.myqademo.controller;

import com.alibaba.fastjson.JSONObject;
import com.javon.myqademo.dao.UserDao;
import com.javon.myqademo.domain.User;
import com.javon.myqademo.service.UserService;
import com.javon.myqademo.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/{studentNo}", method = RequestMethod.GET)
//    public User findUserByNo(@PathVariable String studentNo){
//        logger.debug("查找studentNo=" + studentNo);
//        return userDao.findByStudentNo(studentNo);
//    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User saveUser(User user){
        return userDao.save(user);
    }



    @RequestMapping(value = "/findUserByCode", method = RequestMethod.GET)
    public String login(String code){
        System.out.println(code);
        JSONObject result = HttpClient.wxVerfy(code);
        String openid = result.getString("openid");
        String sessionKey = result.getString("session_key");
        User user = userDao.findByOpenId(openid);
        JSONObject returnResult = new JSONObject();
        returnResult.fluentPut("sessionKey", sessionKey);
        if(user == null){
            returnResult.fluentPut("studentNo", "");
        }else {
            returnResult.fluentPut("studentNo", user.getStudentNo());
        }
        return returnResult.toString();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(String encryptedData,String sessionKey,String iv, String studentNo, String name){
        System.out.println(sessionKey);
        User user = userService.getUserInfo(encryptedData, sessionKey, iv);
        user.setStudentNo(studentNo);
        user.setName(name);
        return userDao.save(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> findAllUser(){
        return userDao.findAllBy();
    }


    @RequestMapping(value = "/getScore", method = RequestMethod.GET)
    public User getScore(String studentNo){
        User user = userDao.findByStudentNo(studentNo);
        return user;
    }


}
