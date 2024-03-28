package com.big.controller;

import com.big.dao.Result;
import com.big.dao.User;
import com.big.service.UserService;
import com.big.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(String username,String password){
        User user = userService.selectUserByUsername(username);
        if(user!=null)
        {
            if (user.getPassword().equals(Md5Util.getMD5String(password))){
                return Result.success(user);
            }else {
                return Result.error("密码错误");
            }
        }

        return Result.success("未注册");
    }

    @PostMapping("/register")
    public Result register(String username,String password){
        User user = userService.selectUserByUsername(username);

        if(user!=null)
        {
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

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        System.out.println(user);
        userService.updateUser(user);
        return Result.success("修改成功");
    }
}
