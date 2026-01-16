package com.example.tilas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;

    private Object data;
    public static Result success(){
        Result result =new Result(0,"success",null);
        return result;
    }

    public static Result success(Object data ){
        Result result =new Result(0,"success",data);
        return result;
    }

    public static Result error(String desc){
        Result result =new Result(1,desc,null);
        return result;
    }
}



