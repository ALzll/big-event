package com.big.mapper;

import com.big.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    //查询用户名
    @Select("select * from user where username=#{username}")
    User selectUserByUsername(String username);

    //插入数据
    @Insert("INSERT INTO user (username,password,create_time,update_time) VALUES(#{username},#{password},NOW(),NOW());")
    void insertUser(User user1);

    @Update("UPDATE user set username = #{username},nickname = #{nickname},email = #{email}, user_pic =#{userPic} WHERE id = #{id};")
    void updateUser(User user);

    @Select("select * from user where id=#{id}")
    User selectUserByID(Integer id);

    @Update("UPDATE user set password = #{newPassword} WHERE id = #{id};")
    void updatePwd(Integer id,String newPassword);
}
