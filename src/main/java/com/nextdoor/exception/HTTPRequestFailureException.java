package com.nextdoor.exception;

public class HTTPRequestFailureException extends APIRequestException {
    public HTTPRequestFailureException() {
    }

    public HTTPRequestFailureException(String s) {
        super(s);
    }

    public HTTPRequestFailureException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public HTTPRequestFailureException(Throwable throwable) {
        super(throwable);
    }

    public HTTPRequestFailureException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
