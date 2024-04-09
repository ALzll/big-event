package com.big.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.big.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArcitleMapper  extends BaseMapper<Article> {
}
