package com.example.tilas.mapper;

import com.example.tilas.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface ClazzMapper {
    List<Clazz> list(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);

    Clazz getById(Integer id);

    void deleteById(Integer id);

    void save(Clazz clazz);

    void update(Clazz clazz);
}
