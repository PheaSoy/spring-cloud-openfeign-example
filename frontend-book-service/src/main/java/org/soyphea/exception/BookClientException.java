package org.soyphea.exception;

public class BookClientException extends RuntimeException{

    public BookClientException() {
    }

    public BookClientException(String message) {
        super(message);
    }
}
