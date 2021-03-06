package com.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Error implements Serializable {

    private static final long serialVersionUID = -432908543160176349L;

    private String code;
    private String message;
    private String success;
    private List<Data> data = new ArrayList<>();


    public Error() {
    }

    public Error(String code, String message, String success, List<Data> data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", success='" + success + '\'' +
                ", data=" + data +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}