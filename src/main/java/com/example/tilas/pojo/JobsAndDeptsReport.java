package com.example.tilas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobsAndDeptsReport {
    private List<String> nameList;
    private List<Object> dataList;
}
