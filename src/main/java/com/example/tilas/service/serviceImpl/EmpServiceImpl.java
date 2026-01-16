package com.example.tilas.service.serviceImpl;

import com.example.tilas.mapper.EmpMapper;
import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.EmpQueryParam;
import com.example.tilas.pojo.PageResult;
import com.example.tilas.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    /*
    老方法
    *
    */

//    @Override
//    public PageResult list(Integer page, Integer pageSize) {
//        //1. 获取总记录数
//        Long total = empMapper.count();
//
//        //2. 获取结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        //3. 封装结果
//        return new PageResult(total, empList);
//    }
    @Override
    public PageResult list(EmpQueryParam q) {

        PageHelper.startPage(q.getPage(),q.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.list(q);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult(p.getTotal(), p.getResult());
    }
}
