package com.example.pwdmanager.mapper;

import com.example.pwdmanager.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT COUNT(*) FROM users " +
            "WHERE name=#{name} AND identification_number=#{identificationNumber} ")
    int selectCount(UserEntity userEntity);
}
