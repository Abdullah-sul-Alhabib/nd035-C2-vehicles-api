package com.udacity.vehicles.domain.manufacturer;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Declares class to hold car manufacturer information.
 */
@Entity
public class Manufacturer {

    @Id
    private Integer code;
    private String name;

    /**
     * Instantiates a new Manufacturer.
     */
    public Manufacturer() {
    }

    /**
     * Instantiates a new Manufacturer.
     *
     * @param code the code
     * @param name the name
     */
    public Manufacturer(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
