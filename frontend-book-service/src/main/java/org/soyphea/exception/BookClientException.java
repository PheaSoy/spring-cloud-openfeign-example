package org.soyphea.exception;

public class BookClientException extends RuntimeException{

    int code;
    String message;

    public BookClientException() {
    }

    public BookClientException(int code,String message)
    {
        super(message);
        this.code = code;
    }
}
