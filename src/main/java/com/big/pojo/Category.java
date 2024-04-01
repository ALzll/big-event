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
public class Category {
    private Integer id;
    @NotNull
    private String categoryName;
    private String categoryAlias;
    private String createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
