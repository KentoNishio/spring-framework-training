package com.example.demo.controller.api;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.model.mapper.MessageMapper;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {

        return userMapper.findById(id);
    }

    @GetMapping("")
    public List<User> all() {
        return userMapper.all();
    }
}
