package br.koakovski.project_manager_api.exceptions.project;

import org.springframework.http.HttpStatus;

import br.koakovski.project_manager_api.exceptions.BaseSystemException;

public class ProjectNotFoundException extends BaseSystemException {
    private static final String DEFAULT_MESSAGE = "Project not found";
    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public ProjectNotFoundException() {
        super(DEFAULT_MESSAGE, DEFAULT_HTTP_STATUS);
    }

    public ProjectNotFoundException(String message) {
        super(
                BaseSystemException.validateMessage(message, DEFAULT_MESSAGE),
                DEFAULT_HTTP_STATUS);
    }

}
