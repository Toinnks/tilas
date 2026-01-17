package com.example.tilas.controller;

import com.example.tilas.mapper.EmpExprMapper;
import com.example.tilas.pojo.*;
import com.example.tilas.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @Autowired
    private EmpExprMapper empExprMapper;


    @GetMapping
    public Result list(@RequestBody EmpQueryParam empQueryParam){

        log.info("分页条件查询员工:{}}",empQueryParam.toString());

        PageResult pageResult = empService.list(empQueryParam);

        return  Result.success(pageResult);
    }

    @Transactional
    @PostMapping
    public Result save(@RequestBody Emp emp){

        log.info("保存员工:{}}",emp.toString());

        empService.save(emp);
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();

        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.saveBatch(exprList);
        }

        return  Result.success();
    }
}
