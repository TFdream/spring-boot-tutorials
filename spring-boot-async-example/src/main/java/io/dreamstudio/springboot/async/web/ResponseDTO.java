package io.dreamstudio.springboot.async.web;

/**
 * @author Ricky Fung
 */
public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;
    public static final int SUCCESS = 1;

    public ResponseDTO() {}

    public static ResponseDTO ok() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(SUCCESS);
        return responseDTO;
    }

    public static <T> ResponseDTO ok(T data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(SUCCESS);
        responseDTO.setData(data);
        return responseDTO;
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
