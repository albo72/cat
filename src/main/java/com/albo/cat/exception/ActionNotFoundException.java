package com.albo.cat.exception;

public class ActionNotFoundException extends Exception{
    public ActionNotFoundException(String message) {
        super(message);
    }

    public ActionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionNotFoundException(Throwable cause) {
        super(cause);
    }
}
