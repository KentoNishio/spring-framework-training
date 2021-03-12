package com.example.demo.model.mapper;

import com.example.demo.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {
    Message findById(@Param("id") int id);
}
