package com.example.tilas.service;

import com.example.tilas.pojo.Dept;

import java.util.List;


public interface DeptService {
    public List<Dept> findAll();
    public void deleteById(Integer id);

    public void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}