package com.example.demo.model.mapper;

import com.example.demo.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Account findById(@Param("id") int id);
    Account findByMail(@Param("mail") String mail);
    List<Account> all();
}
