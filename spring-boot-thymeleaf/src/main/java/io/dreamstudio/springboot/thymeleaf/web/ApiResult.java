package io.dreamstudio.springboot.thymeleaf.web;

import java.io.Serializable;

/**
 * @author Ricky Fung
 */
public class ApiResult<T> implements Serializable {

    private static final int SUCCESS_CODE = 1;
    private static final String SUCCESS_MSG = "OK";

    private int code;
    private String message;
    private T data;

    public ApiResult() {
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //------------------
    public static <T> ApiResult<T> buildSuccess() {
        return new ApiResult(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> ApiResult<T> buildSuccess(T data) {
        return new ApiResult(SUCCESS_CODE, SUCCESS_MSG, data);
    }
    //----------------
    public static <T> ApiResult<T> buildFailure(int code, String message) {
        return new ApiResult(code, message, null);
    }

    //-------------
    public static <T> ApiResult<T> buildSysError() {
        return new ApiResult(500, "系统出了一点小问题，请稍后再试", null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
