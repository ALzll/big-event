package com.big.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.big.mapper.ArcitleMapper;
import com.big.mapper.CategoryMapper;
import com.big.pojo.Article;
import com.big.pojo.Category;
import com.big.pojo.PageBean;
import com.big.pojo.User;
import com.big.mapper.UserMapper;
import com.big.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArcitleMapper arcitleMapper;

    //注册
    //插入数据
    @Override
    public void insertUser(User user1) {

//        userMapper.insertUser(user1);
        user1.setUpdateTime(LocalDateTime.now());
        user1.setCreateTime(LocalDateTime.now());
        userMapper.insert(user1);
    }


    //查询用户名是否存在
    @Override
    public User selectUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("iii",username);
      //
        User user = userMapper.selectOne(queryWrapper);
        return user ;
    }

    //修改用户信息
    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
//        userMapper.updateUser(user);
    }


    //查询ID
    @Override
    public User selectUserByID(Integer id) {
        return userMapper.selectById(id);
    }

    //更新密码
    @Override
    public void updatePwd(Integer id,String newPassword) {
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId,id);
        lambdaUpdateWrapper.set(User::getPassword,newPassword);
        userMapper.update(lambdaUpdateWrapper);
//        userMapper.updatePwd(id,newPassword);
    }



    //文章分类（增）
    @Override
    public void  inserCategory(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateTime(LocalDateTime.now());
        categoryMapper.insert(category);
    }



    //文章分类（删）
    @Override
    public void deleteCategoryByCategoryId(Integer id) {
        categoryMapper.deleteById(id);
    }

    //文章分类（改）
    @Override
    public void uodateCategory(Category category) {
        categoryMapper.updateById(category);

    }

    //文章分类（查）
    @Override
    public List<Category> selectCategorys() {

        return categoryMapper.selectList(null);
    }


    //文章（增）
    @Override
    public void inserArcitle(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        arcitleMapper.insert(article);
    }

    //文章（删）
    @Override
    public void deleteArticleByArticleId(Integer id) {
        arcitleMapper.deleteById(id);
    }

    //文章（改）
    @Override
    public void uodateArticle(Article article) {
        arcitleMapper.updateById(article);

    }

    //文章（查）
    @Override
    public PageBean<Article> selectArticlepage(Integer page, Integer size) {
        Page<Article> articlePage = new Page<>(page,size);

        Page<Article> page1 = arcitleMapper.selectPage(articlePage,null);
        PageBean<Article> pageBean = new PageBean<>();
        pageBean.setTotal(page1.getTotal());
        pageBean.setItems(page1.getRecords());
        return pageBean;
    }


}
