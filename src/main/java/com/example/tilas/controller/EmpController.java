package com.example.tilas.controller;

import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.EmpQueryParam;
import com.example.tilas.pojo.PageResult;
import com.example.tilas.pojo.Result;
import com.example.tilas.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
