package com.example.tilas.service;

import com.example.tilas.pojo.Dept;
import com.example.tilas.pojo.JobsAndDeptsReport;

import java.util.List;


public interface DeptService {
    public List<Dept> findAll();
    public void deleteById(Integer id);

    public void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
//    JobsAndDeptsReport getDeptEmpNums();
}