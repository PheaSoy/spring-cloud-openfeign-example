package org.soyphea.exception;

public class BookServerException extends RuntimeException{

    int code;
    String message;

    public BookServerException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
