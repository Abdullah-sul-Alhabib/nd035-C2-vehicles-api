package com.udacity.vehicles.client.prices;

import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */
public class Price {

    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    /**
     * Instantiates a new Price.
     */
    public Price() {
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets vehicle id.
     *
     * @return the vehicle id
     */
    public Long getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets vehicle id.
     *
     * @param vehicleId the vehicle id
     */
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
