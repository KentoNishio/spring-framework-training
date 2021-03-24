package com.example.demo.controller.api;

import com.example.demo.model.Message;
import com.example.demo.model.mapper.MessageMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    @Autowired
    private MessageMapper messageMapper;

    @GetMapping("/{id}")
    public Message message(@PathVariable int id) {

        return messageMapper.findById(id);
    }

    @GetMapping("")
    public List<String> message(@RequestParam("prefecture") List<String> prefectures) {
        return prefectures;
    }
}
