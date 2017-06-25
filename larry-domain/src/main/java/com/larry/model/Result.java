package com.larry.model;

import com.larry.enums.ResultCode;

/**
 * Created by huang on 2017/5/6.
 */
public class Result {

    private ResultCode code;

    private Object data;

    private String message;

    public Result() {

    }

    public Result(ResultCode code) {
        this.code = code;
    }

    public Result(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(ResultCode code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static Result info(String msg){
        return new Result(ResultCode.SUCCESS,msg);
    }

    public static Result error(String msg){
        return new Result(ResultCode.ERROR,msg);
    }


    public ResultCode getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = ResultCode.valueOf(code);
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
