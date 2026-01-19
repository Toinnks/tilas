package com.example.tilas.service;

import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.EmpQueryParam;
import com.example.tilas.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult list(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);
}
