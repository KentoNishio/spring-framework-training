package com.example.demo.controller.api;

import com.example.demo.model.Message;
import com.example.demo.model.mapper.MessageMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    private final MessageMapper messageMapper;

    public MessageController(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @GetMapping("/{id}")
    public Message message(@PathVariable int id) {

        return messageMapper.findById(id);
    }

    @GetMapping("")
    public List<String> message(@RequestParam("prefecture") List<String> prefectures) {
        return prefectures;
    }

    // パスワード生成用
    @GetMapping("bcrypt")
    public String bcrypt() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = "password";

        return passwordEncoder.encode(password);

    }
}
