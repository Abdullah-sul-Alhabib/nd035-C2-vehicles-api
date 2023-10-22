package com.udacity.pricingMicroservice.repository;

import com.udacity.pricingMicroservice.entity.Price;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Price repository.
 */
public interface PriceRepository extends CrudRepository<Price, Long> {
}
