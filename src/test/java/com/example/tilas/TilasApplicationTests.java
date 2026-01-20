package com.example.tilas;

import com.example.tilas.mapper.DeptMapper;
import com.example.tilas.mapper.EmpMapper;
import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.JobsAndDeptsReport;
import com.example.tilas.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Consumer;

@Slf4j
@SpringBootTest
class TilasApplicationTests {
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    EmpMapper empMapper;

    @Test
    public void myTest(){
        log.info("{}",TimeUtils.getCurrentTime());
    }


}
