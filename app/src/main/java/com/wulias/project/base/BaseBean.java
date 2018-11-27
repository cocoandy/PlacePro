package com.wulias.project.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/9.
 */

public class BaseBean<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
