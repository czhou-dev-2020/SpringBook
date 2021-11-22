package com.rillsoft.springbookadmin.Exception;

/*
    Refer to:
    https://github.com/javadevjournal/javadevjournal/tree/master/spring-security/spring-security-series/
        src/main/java/com/javadevjournal/core/exception/UnkownIdentifierException.java
    In case customer account does not exists in the system for a given email id.
*/

public class UnkownIdentifierException extends Exception {

    public UnkownIdentifierException() {
        super();
    }

    public UnkownIdentifierException(String message) {
        super(message);
    }

    public UnkownIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}
