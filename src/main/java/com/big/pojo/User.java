package com.big.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    @NotNull @Pattern(regexp = "^\\S{4,8}$")
    private String username;
    @JsonIgnore
    private String password;
    @NotNull @Pattern(regexp = "^\\S{6,14}$")
    private String nickname;
    @Email(message = "邮箱错误")
    private String email;
    @NotNull
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
