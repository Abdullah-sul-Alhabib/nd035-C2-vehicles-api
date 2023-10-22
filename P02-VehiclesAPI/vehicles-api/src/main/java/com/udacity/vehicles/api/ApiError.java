package com.udacity.vehicles.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Declares methods to return errors and other messages from the API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiError {

    private final String message;
    private final List<String> errors;

    /**
     * Instantiates a new Api error.
     *
     * @param message the message
     * @param errors  the errors
     */
    ApiError(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }
}
