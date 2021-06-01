package com.example.pwdmanager.mapper;

import com.example.pwdmanager.entity.AccountInfoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountInfoMapper {
    @Select("SELECT * FROM account_infos " +
            "WHERE uid=#{uid}")
    List<AccountInfoEntity> selectAccountInfos(@Param("uid") String uid);

    @Insert("INSERT INTO account_infos(uid,account,password,script) " +
            "VALUES(#{uid},#{account},#{password},#{script})")
    int insertAccountInfo(AccountInfoEntity accountInfoEntity);

    @Delete("DELETE FROM account_infos " +
            "WHERE id=#{id}")
    int deleteAccountInfo(@Param("id") int id);

    @Update("UPDATE account_infos " +
            "SET account=#{account},password=#{password},script=#{script}" +
            "WHERE id=#{id}")
    int updateAccountInfo(AccountInfoEntity accountInfoEntity);
}
