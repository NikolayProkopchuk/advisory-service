package com.prokopchuk.advisoryservice.exception;

public class AdvisoryException extends RuntimeException{
    public AdvisoryException(String message) {
        super(message);
    }

    public AdvisoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
