package com.rillsoft.springbookadmin.Exception;

public class UserPhoneAlreadyExistException  extends UserAlreadyExistException {
    public UserPhoneAlreadyExistException() {
        super();
    }

    public UserPhoneAlreadyExistException(String message) {
        super(message);
    }

    public UserPhoneAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
