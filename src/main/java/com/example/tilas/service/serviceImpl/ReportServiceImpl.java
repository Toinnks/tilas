package com.example.tilas.service.serviceImpl;

import com.example.tilas.mapper.DeptMapper;
import com.example.tilas.mapper.EmpMapper;
import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.JobsAndDeptsReport;
import com.example.tilas.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;


    @Override
    public JobsAndDeptsReport countDeptEmpData() {
        List<HashMap<String, Object>> list = deptMapper.countDeptEmpData();
        List<Object> dataList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        list.forEach(s -> {
            nameList.add(s.get("dept_name").toString());
            dataList.add(s.get("num"));
        });
        return new JobsAndDeptsReport(nameList, dataList);
    }

    @Override
    public JobsAndDeptsReport countEmpJobData() {
        List<HashMap<String, Object>> list = empMapper.countEmpJobData();
        List<Object> dataList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        list.forEach(s -> {
            nameList.add(s.get("pos").toString());
            dataList.add(s.get("num"));
        });
        return new JobsAndDeptsReport(nameList, dataList);
    }

    @Override
    public JobsAndDeptsReport countEmpGenderData() {

        List<HashMap<String, Object>> list = empMapper.countEmpGenderData();
        List<Object> dataList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        list.forEach(s -> {
            nameList.add(s.get("gender").toString());
            dataList.add(s.get("num"));
        });
        return new JobsAndDeptsReport(nameList, dataList);
    }
}
