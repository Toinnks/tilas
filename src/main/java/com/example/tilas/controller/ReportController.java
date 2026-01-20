package com.example.tilas.controller;


import com.example.tilas.pojo.JobsAndDeptsReport;
import com.example.tilas.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reports")
@RestController
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/jopEmp")
    public JobsAndDeptsReport countJobEmpData(){

        return reportService.countEmpJobData();
    }
    @GetMapping("/deptEmp")
    public JobsAndDeptsReport countDeptEmpData(){

        return reportService.countDeptEmpData();
    }
    @GetMapping("/genderEmp")
    public JobsAndDeptsReport countEmpGenderData(){

        return reportService.countEmpGenderData();
    }

}
