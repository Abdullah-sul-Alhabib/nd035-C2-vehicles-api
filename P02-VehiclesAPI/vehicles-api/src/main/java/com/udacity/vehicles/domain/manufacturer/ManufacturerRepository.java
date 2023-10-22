package com.udacity.vehicles.domain.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Manufacturer repository.
 */
@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
