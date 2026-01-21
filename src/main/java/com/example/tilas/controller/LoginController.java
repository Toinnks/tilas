package com.example.tilas.controller;

import com.example.tilas.pojo.Emp;
import com.example.tilas.pojo.LoginInfo;
import com.example.tilas.pojo.Result;
import com.example.tilas.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @GetMapping("/login")
    public Result login(@RequestBody Emp emp) {
        LoginInfo logininfo = empService.login(emp);
        if (logininfo != null){
            return Result.success(logininfo);
        }else {
            return Result.error("用户名或密码错误");
        }
    }
}
