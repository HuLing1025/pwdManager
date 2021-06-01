package com.example.pwdmanager.controller;

import com.example.pwdmanager.entity.AccountInfoEntity;
import com.example.pwdmanager.entity.UserEntity;
import com.example.pwdmanager.mapper.AccountInfoMapper;
import com.example.pwdmanager.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@RestController
@RequestMapping("/pwdManager")
@Api(tags = "密码盒子")
public class AccountInfoController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AccountInfoMapper accountInfoMapper;

    @PostMapping("/list")
    @ApiOperation(value ="列表")
    public HashMap<String, Object> list(@RequestBody UserEntity userEntity) {
        HashMap<String, Object> responseBody = new HashMap<>();
        if (userMapper.selectCount(userEntity) == 1) {
            responseBody.put("code", 200);
            responseBody.put("data", accountInfoMapper.selectAccountInfos(userEntity.getIdentificationNumber()));
        }else{
            responseBody.put("code", 400);
            responseBody.put("msg", "账户或密码错误!");
        }
        return responseBody;
    }

    @PostMapping("/add")
    @ApiOperation("新增")
    public HashMap<String, Object> add(@RequestBody AccountInfoEntity accountInfoEntity) {
        HashMap<String, Object> responseBody = new HashMap<>();
        if (accountInfoMapper.insertAccountInfo(accountInfoEntity) == 1) {
            responseBody.put("code", 200);
        }else{
            responseBody.put("code", 500);
            responseBody.put("msg", "新增失败!");
        }
        return responseBody;
    }

    @PutMapping("/update")
    @ApiOperation("修改")
    public HashMap<String, Object> update(@RequestBody AccountInfoEntity accountInfoEntity) {
        HashMap<String, Object> responseBody = new HashMap<>();
        if (accountInfoMapper.updateAccountInfo(accountInfoEntity) == 1) {
            responseBody.put("code", 200);
        }else {
            responseBody.put("code", 500);
            responseBody.put("msg", "修改失败!");
        }
        return responseBody;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public HashMap<String, Object> delete(@PathVariable("id") int id) {
        HashMap<String, Object> responseBody = new HashMap<>();
        if (accountInfoMapper.deleteAccountInfo(id) == 1) {
            responseBody.put("code", 200);
        }else{
            responseBody.put("code", 500);
            responseBody.put("msg", "删除失败!");
        }
        return responseBody;
    }
}
