package com.example.tilas.service;

import com.example.tilas.pojo.Clazz;
import com.example.tilas.pojo.PageResult;
import com.example.tilas.pojo.Result;

import java.time.LocalDate;

public interface ClazzService {
    PageResult list(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);

    Clazz getById(Integer id);

    void deleteById(Integer id);

    void save(Clazz clazz);

    void update(Clazz clazz);
}
