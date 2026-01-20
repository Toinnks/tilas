package com.example.tilas.controller;


import com.example.tilas.pojo.Clazz;
import com.example.tilas.pojo.PageResult;
import com.example.tilas.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.tilas.service.ClazzService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping("/list")
    public Result list(@RequestParam(name = "page",defaultValue = "1") Integer page
                            , @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize
                            , @RequestParam(name = "name",required = false) String name
                            , @RequestParam(name = "end",required = false) LocalDate end
                            , @RequestParam(name = "begin",required = false) LocalDate begin){

        PageResult list = clazzService.list(page, pageSize, name, begin, end);
        return Result.success(list);

    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){

        Clazz clazz= clazzService.getById(id);
        return Result.success(clazz);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){

      clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        clazzService.save(clazz);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }
}
