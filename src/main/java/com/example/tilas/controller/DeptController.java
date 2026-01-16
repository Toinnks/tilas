package com.example.tilas.controller;

import com.example.tilas.pojo.Dept;
import com.example.tilas.pojo.Result;
import com.example.tilas.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")//可以抽取各个接口的公共路径
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
//    @RequestMapping是任何请求都可以参与进来
    @GetMapping
    public Result list(){
        List<Dept> list = deptService.findAll();
        return Result.success(list);
    }
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门id为{}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门："+dept.toString());
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("{id}")
    public Result add(@PathVariable Integer id){
        log.info("id查询部门："+id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门："+dept.toString());
        deptService.update(dept);
        return Result.success();
    }
}
