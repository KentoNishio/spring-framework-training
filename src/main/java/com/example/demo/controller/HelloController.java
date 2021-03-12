package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.model.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class HelloController {

    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/{id}")
    public Message message(@PathVariable int id) {

        Message message = messageMapper.findById(id);

        return message;
    }
}
