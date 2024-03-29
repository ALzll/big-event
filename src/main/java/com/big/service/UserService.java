package com.big.service;

import com.big.pojo.User;

public interface UserService {

    void insertUser(User user1);

    User selectUserByUsername(String username);

    void updateUser(User user);
}
