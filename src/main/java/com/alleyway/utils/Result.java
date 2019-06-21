package com.alleyway.utils;



import com.alleyway.interfaces.StatusCodeInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 * @create_date 2018-12-26 16:35
 *
 * 用于封装结果集
 */
public class Result {
    private Integer code;
    // 封装返回的对象
    private Object content;
    private String msg = "OK";

    /**
     * 处理成功 使用默认状态码（0）
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(StatusCodeInterface.SUCCEED);
        return result;
    }

    /**
     * 处理成功 快速插入对象
     * @return
     */
    public static Result success(Object content){
        Result result = new Result();
        result.setContent(content);
        result.setCode(StatusCodeInterface.SUCCEED);
        return result;
    }

    /**
     * 处理成功 快速插入对象  与  提示信息
     * @return
     */
    public static Result success(Object content,String msg){
        Result result = new Result();
        result.setContent(content);
        result.setMsg(msg);
        result.setCode(StatusCodeInterface.SUCCEED);
        return result;
    }

    /**
     * 处理成功 自定义状态码
     * @param code
     * @return
     */
    public static Result success(Integer code){
        Result result = new Result();
        result.setCode(code);
        return result;
    }

    /**
     * 处理成功 自定义成功信息
     * @param msg
     * @return
     */
    public static Result success(String msg){
        Result result = new Result();
        result.setCode(StatusCodeInterface.SUCCEED);
        result.setMsg(msg);
        return result;
    }

    /**
     * 处理成功 自定义状态码 自定义成功信息
     * @param code
     * @param msg
     * @return
     */
    public static Result success(Integer code,String msg){
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    /**
     * 处理失败 使用默认错误码（1）
     * @return
     */
    public static Result failure(){
        Result result = new Result();
        result.setCode(StatusCodeInterface.FAILING);
        return  result;
    }

    /**
     * 处理失败 自定义错误信息
     * @param msg 错误信息
     * @return
     */
    public static Result failure(String msg){
        Result result = new Result();
        result.setCode(StatusCodeInterface.FAILING);
        result.setMsg(msg);
        return  result;
    }

    /**
     * 处理失败 自定义错误码
     * @return
     */
    public static Result failure(Integer code){
        Result result = new Result();
        result.setCode(code);
        return result;
    }

    /**
     * 处理错误 自定义错误码 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result failure(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
