package com.example.tilas.service.serviceImpl;

import com.example.tilas.mapper.DeptMapper;
import com.example.tilas.pojo.Dept;
import com.example.tilas.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.finaAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        dept.setUpdateTime(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        deptMapper.update(dept);
    }
}
