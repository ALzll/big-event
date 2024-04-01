package com.big.service.impl;

import com.big.mapper.CategoryMapper;
import com.big.pojo.Category;
import com.big.pojo.User;
import com.big.mapper.UserMapper;
import com.big.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    //注册
    //插入数据
    @Override
    public void insertUser(User user1) {

        userMapper.insertUser(user1);
    }

    //查询用户名是否存在
    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    //修改用户信息
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    //查询ID
    @Override
    public User selectUserByID(Integer id) {
        return userMapper.selectUserByID(id);
    }

    //更新密码
    @Override
    public void updatePwd(Integer id,String newPassword) {
        userMapper.updatePwd(id,newPassword);
    }

    //文章分类（增）
    @Override
    public Category selectCategoryByCategoryName(String category_name) {
        return categoryMapper.selectCategoryByCategoryName(category_name);
    }

    //文章分类（删）
    @Override
    public void deleteCategoryByCategoryId(Integer id) {
        categoryMapper.deleteCategoryByCategoryId(id);
    }

}
