package com.big.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @TableId(type = IdType.AUTO )
    private Integer id;
    private String title ;
    private String content ;
    private String cover_img ;
    private String state ;
    private Integer category_id ;
    private Integer create_user ;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
