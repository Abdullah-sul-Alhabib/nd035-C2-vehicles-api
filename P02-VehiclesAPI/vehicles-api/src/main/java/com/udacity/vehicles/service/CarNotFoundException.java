package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Car not found exception.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car not found")
public class CarNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Car not found exception.
     */
    public CarNotFoundException() {
    }

    /**
     * Instantiates a new Car not found exception.
     *
     * @param message the message
     */
    public CarNotFoundException(String message) {
        super(message);
    }
}
