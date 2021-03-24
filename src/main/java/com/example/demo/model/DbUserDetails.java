package com.example.demo.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class DbUserDetails extends User {
    //ユーザ情報。
    private final Account account;

    public DbUserDetails(Account account,
                         Collection<GrantedAuthority> authorities) {

        super(account.mail(), account.password(),
                true, true, true, true, authorities);

        this.account = account;
    }

}