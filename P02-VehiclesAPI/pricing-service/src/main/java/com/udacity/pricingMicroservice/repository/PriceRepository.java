package com.udacity.pricingMicroservice.repository;

import com.udacity.pricingMicroservice.entity.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price,Long> {
}
