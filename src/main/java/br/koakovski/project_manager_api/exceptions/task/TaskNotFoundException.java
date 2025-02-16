package br.koakovski.project_manager_api.exceptions.task;

import org.springframework.http.HttpStatus;

import br.koakovski.project_manager_api.exceptions.BaseSystemException;

public class TaskNotFoundException extends BaseSystemException {
    private static final String DEFAULT_MESSAGE = "Task not found";
    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public TaskNotFoundException() {
        super(DEFAULT_MESSAGE, DEFAULT_HTTP_STATUS);
    }

    public TaskNotFoundException(String message) {
        super(
                BaseSystemException.validateMessage(message, DEFAULT_MESSAGE),
                DEFAULT_HTTP_STATUS);
    }

}
