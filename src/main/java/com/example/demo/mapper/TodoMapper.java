package com.example.demo.mapper;

import com.example.demo.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    void insert(Todo todo);
    Todo select(int id);
}