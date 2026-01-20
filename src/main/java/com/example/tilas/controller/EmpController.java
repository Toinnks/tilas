package com.example.tilas.controller;

import com.example.tilas.mapper.EmpExprMapper;
import com.example.tilas.pojo.*;
import com.example.tilas.service.EmpService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;



    @GetMapping
    public Result list(@RequestBody EmpQueryParam empQueryParam){

        log.info("分页条件查询员工:{}}",empQueryParam.toString());

        PageResult pageResult = empService.list(empQueryParam);
        return  Result.success(pageResult);
    }


    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){

        log.info("删除员工:{}}",ids);
        empService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){

        log.info("保存员工:{}}",emp.toString());

        empService.save(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Integer id){

        log.info("id查询员工:{}",id);

        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){

        log.info("修改员工:{}",emp.toString());

        empService.update(emp);
        return Result.success();
    }
}
