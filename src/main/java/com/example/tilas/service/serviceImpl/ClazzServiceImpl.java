package com.example.tilas.service.serviceImpl;

import com.example.tilas.mapper.ClazzMapper;
import com.example.tilas.pojo.Clazz;
import com.example.tilas.pojo.PageResult;
import com.example.tilas.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult list(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Clazz> list = clazzMapper.list(page, pageSize, name, begin, end);
        LocalDate now = LocalDate.now();
        list.forEach(clazz -> {
            if(clazz.getEndDate().isBefore(now)){
                clazz.setStatus("已结课");
            }else if(clazz.getBeginDate().isAfter(now)){
                clazz.setStatus("未开班");
            }else{
                clazz.setStatus("进行中");
            }
        });
        Page<Clazz> p = (Page<Clazz>) list;
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public Clazz getById(Integer id) {
        Clazz clazz = clazzMapper.getById(id);
        return clazz;
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }
}
