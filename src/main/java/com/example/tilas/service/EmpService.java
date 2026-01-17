package com.example.tilas.service;

import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.EmpQueryParam;
import com.example.tilas.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    PageResult list(EmpQueryParam empQueryParam);

    void save(Emp emp);



}
