package com.example.tilas.mapper;

import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;


import java.util.HashMap;
import java.util.List;

@Mapper
public interface EmpMapper {

    /*
    老方法

    老分页的话需要使用两条sql
    */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
//    Long count();
//
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);


     /*
    新方法

    使用新的分页的话只需要全部查询就好了
    */
    List<Emp> list(EmpQueryParam queryParam);

    void save(Emp emp);


    void deleteByIds(List<Integer> ids);


    Emp getById(Integer id);


    void update(Emp emp);

    List<HashMap<String,Object>> countEmpJobData();

    List<HashMap<String,Object>> countEmpGenderData();

}
