package com.hh.springsecurity.exception;

public class NotFoundUserNameException extends RuntimeException {

    public NotFoundUserNameException(String message) {
        super(message);
    }

    public NotFoundUserNameException() {
        super();
    }

    public NotFoundUserNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundUserNameException(Throwable cause) {
        super(cause);
    }

    protected NotFoundUserNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
