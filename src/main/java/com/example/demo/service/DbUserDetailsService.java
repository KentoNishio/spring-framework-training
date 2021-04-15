package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Account;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String mail)
            throws UsernameNotFoundException {
        //DBからユーザ情報を取得。
        Account account = Optional.ofNullable(userMapper.findByMail(mail))
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new User(account.mail(), account.password(), AuthorityUtils.createAuthorityList("USER"));
    }
}