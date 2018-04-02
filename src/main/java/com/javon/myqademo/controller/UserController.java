package com.javon.myqademo.controller;

import com.alibaba.fastjson.JSONObject;
import com.javon.myqademo.dao.UserDao;
import com.javon.myqademo.domain.User;
import com.javon.myqademo.service.UserService;
import com.javon.myqademo.utils.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


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



    @RequestMapping(value = "/wxlogin", method = RequestMethod.POST)
    public String login(String code){
        System.out.println(code);
        JSONObject result = HttpClient.wxVerfy(code);
        return result.toString();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(String encryptedData,String sessionKey,String iv){
        User user = userService.getUserInfo(encryptedData, sessionKey, iv);
        return userDao.save(user);
    }

    @RequestMapping(value = "/addtionInfo", method = RequestMethod.POST)
    public void addtionInfo(String studentNo, String name, String userId){
        userDao.updateOne(studentNo,name,userId);
    }

}
