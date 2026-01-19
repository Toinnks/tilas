package com.example.tilas.service.serviceImpl;

import com.example.tilas.mapper.EmpLogMapper;
import com.example.tilas.pojo.EmpLog;
import com.example.tilas.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void add(EmpLog empLog) {
        empLogMapper.add(empLog);
    }
}
