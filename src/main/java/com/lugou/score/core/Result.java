package com.lugou.score.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result<T> {
    private int code;
    private String message;
    private T data;
    private int count;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result setCount(int count) {
        this.count = count;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
