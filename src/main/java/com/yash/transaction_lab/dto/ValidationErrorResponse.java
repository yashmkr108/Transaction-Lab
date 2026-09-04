package com.yash.transaction_lab.dto;

import java.time.Instant;
import java.util.Map;

public class ValidationErrorResponse {

    private int status;
    private String message;
    private Instant timestamp;
    private Map<String, String> errors;

    public ValidationErrorResponse(
            int status,
            String message,
            Instant timestamp,
            Map<String, String> errors
    ) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}