package com.jiangzhou.seed.core;

public class ServiceException extends RuntimeException {
    public int code;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
        this.code = 10000;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
