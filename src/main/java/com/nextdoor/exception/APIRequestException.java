package com.nextdoor.exception;

public class APIRequestException extends Exception {
    public APIRequestException() {
    }

    public APIRequestException(String s) {
        super(s);
    }

    public APIRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public APIRequestException(Throwable throwable) {
        super(throwable);
    }

    public APIRequestException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
