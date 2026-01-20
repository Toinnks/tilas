package com.example.tilas.mapper;

import com.example.tilas.pojo.Dept;
import com.example.tilas.pojo.JobsAndDeptsReport;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id,name,create_time,update_time from dept")
    public List<Dept> finaAll();

    @Delete("delete from dept where id =#{id}")
    public void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    public void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name =#{name} ,update_time=#{updateTime} where id = #{id};")
    void update(Dept dept);

    List<HashMap<String, Object>> countDeptEmpData();
}
