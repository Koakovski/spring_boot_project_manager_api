package br.koakovski.project_manager_api.exceptions;

import org.springframework.http.HttpStatus;

public class BaseSystemException extends RuntimeException {
    private final HttpStatus httpStatus;

    public BaseSystemException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static String validateMessage(String message, String defaultMessage) {
        return message != null && !message.isEmpty() ? message : defaultMessage;
    }
}
