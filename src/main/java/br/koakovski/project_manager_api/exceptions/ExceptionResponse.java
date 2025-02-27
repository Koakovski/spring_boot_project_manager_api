package br.koakovski.project_manager_api.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}