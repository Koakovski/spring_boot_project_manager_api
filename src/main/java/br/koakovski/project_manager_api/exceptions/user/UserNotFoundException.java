package br.koakovski.project_manager_api.exceptions.user;

import org.springframework.http.HttpStatus;

import br.koakovski.project_manager_api.exceptions.BaseSystemException;

public class UserNotFoundException extends BaseSystemException {
    private static final String DEFAULT_MESSAGE = "User not found";
    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE, DEFAULT_HTTP_STATUS);
    }

    public UserNotFoundException(String message) {
        super(
                BaseSystemException.validateMessage(message, DEFAULT_MESSAGE),
                DEFAULT_HTTP_STATUS);
    }

}
