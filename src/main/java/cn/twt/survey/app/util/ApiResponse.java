package cn.twt.survey.app.util;

import org.apache.catalina.mapper.Mapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    private int code;
    private String message;
    private Object result;

    public ApiResponse(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static ApiResponse success(Object result){
        return new ApiResponse(200,"ok",result);
    }
    public static ApiResponse fail(int code,String message){
        return new ApiResponse(code,message,null);
    };

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }
}
