package com.example.tilas.mapper;

import com.example.tilas.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void saveBatch(List<EmpExpr> exprList);

    void deleteByIds(List<Integer> ids);

    void update(List<EmpExpr> exprList);
}
