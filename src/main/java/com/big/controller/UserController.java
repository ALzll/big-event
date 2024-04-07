package com.big.controller;

import com.big.pojo.Category;
import com.big.pojo.Result;
import com.big.pojo.User;
import com.big.service.UserService;
import com.big.utils.Md5Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public Result login(@NotNull @Pattern(regexp = "^\\S{4,8}$") String username, @NotNull @Pattern(regexp = "^\\S{6,14}$") String password) {
        User user = userService.selectUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(Md5Util.getMD5String(password))) {
                return Result.success(user);
            } else {
                return Result.error("密码错误");
            }
        }

        return Result.success("未注册");
    }

    //注册
    @PostMapping("/register")
    public Result register(@NotNull @Pattern(regexp = "^\\S{4,8}$") String username, @NotNull @Pattern(regexp = "^\\S{6,14}$") String password) {
        if (username != null && password != null)
            if (username.length() < 4 || password.length() < 4) {
                return Result.error("用户名或密码输入不合法");
            }
        User user = userService.selectUserByUsername(username);

        if (user != null) {
            System.out.println(user);
            return Result.error("用户名已存在");
        }

        User user1 = new User();
        user1.setUsername(username);
        String md5PwdStr = Md5Util.getMD5String(password);
        user1.setPassword(md5PwdStr);

        userService.insertUser(user1);
        return Result.success("注册成功");
    }

    //修改用户信息
    @PostMapping("/update")
    public Result update(@Valid @RequestBody User user) {
        System.out.println(user);
        userService.updateUser(user);
        return Result.success("修改成功");
    }

    //修改用户密码
    @PostMapping("/updatepwd")
    public Result updatepwd(Integer id,String old_password,String new_password){

        User user = userService.selectUserByID(id);
        if (user != null) {
            System.out.println(user);
            if (user.getPassword().equals(Md5Util.getMD5String(old_password))){

                System.out.println(id);
                System.out.println(old_password);
                System.out.println(new_password);

                userService.updatePwd(id,Md5Util.getMD5String(new_password));
                return Result.success("修改成功！");
            }else {
                return Result.success("旧密码错误！！！");

            }
        }

        return Result.success("牛头不对马嘴错误！！！");

    }

    //文章分类
    //增

    @PostMapping("/addCategory")
    public  Result addCategory(@RequestBody Category category){
        System.out.println("add");
        userService.inserCategory(category);
        System.out.println(category);
        return Result.success("新增成功");
    }

    //删
    @PostMapping("/deleteCategory")
    public Result deleteCategory(Integer id){
//        if ()
        System.out.println(id);
        userService.deleteCategoryByCategoryId(id);
//

//        Category category1 = new Category();
//        category1.setUsername(username);
//        String md5PwdStr = Md5Util.getMD5String(password);
//        user1.setPassword(md5PwdStr);
//
//        userService.insertUser(user1);
        return Result.success("成功");
    }

    //改
    @PostMapping("/updateCategory")
    public Result updateCategory(@RequestBody Category category){
        userService.uodateCategory(category);
        return Result.success("修改成功");
    }
    //查
    @PostMapping("/selectCategory")
    public Result selectCategory(){
        return Result.success(userService.selectCategorys());
    }


}
