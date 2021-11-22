package com.rillsoft.springbookadmin.Exception;

public class UserEmailAlreadyExistException  extends UserAlreadyExistException {

    public UserEmailAlreadyExistException() {
        super();
    }

    public UserEmailAlreadyExistException(String message) {
        super(message);
    }

    public UserEmailAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}

