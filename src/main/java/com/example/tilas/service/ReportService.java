package com.example.tilas.service;

import com.example.tilas.pojo.JobsAndDeptsReport;

public interface ReportService {

    JobsAndDeptsReport countDeptEmpData();
    JobsAndDeptsReport countEmpJobData();
    JobsAndDeptsReport countEmpGenderData();

}
