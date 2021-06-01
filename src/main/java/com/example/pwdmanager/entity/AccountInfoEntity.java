package com.example.pwdmanager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountInfoEntity {
    int id;
    String uid;
    String account;
    String password;
    String script;
}
