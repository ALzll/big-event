package com.big.controller;

import com.big.pojo.Result;
import com.big.pojo.User;
import com.big.service.UserService;
import com.big.utils.Md5Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        userService.updateUser(user);
        return Result.success("修改成功");
    }
}
