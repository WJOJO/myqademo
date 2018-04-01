package com.javon.myqademo.service;

import com.javon.myqademo.domain.User;

public interface UserService {
    User getUserInfo(String encryptedData, String sessionKey, String iv);
}
