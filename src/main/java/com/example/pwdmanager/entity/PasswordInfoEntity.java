package com.example.pwdmanager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PasswordInfoEntity {
    int id;
    String username;
    String password;
    String script;
}
