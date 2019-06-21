package com.alleyway.interfaces;

/**
 * @author zhy
 * @create_date 2018-12-29 17:45
 *
 * 状态码接口
 */
public interface StatusCodeInterface {

    // 公共的
   final Integer SUCCEED = 0; // 处理成功
   final Integer FAILING = 1; // 普通处理失败
   final Integer DATAFORMAT_WRONG = 7; //上传data格式错误
   final Integer GET_DATE_NULL = 8;  //要获取的数据为空






}
