package com.big.service;

import com.big.pojo.Category;
import com.big.pojo.User;

public interface UserService {

    void insertUser(User user1);

    User selectUserByUsername(String username);

    void updateUser(User user);

    User selectUserByID(Integer id);

    void updatePwd(Integer id,String newPassword);

    Category selectCategoryByCategoryName(String category_name);

    void deleteCategoryByCategoryId(Integer id);
}
