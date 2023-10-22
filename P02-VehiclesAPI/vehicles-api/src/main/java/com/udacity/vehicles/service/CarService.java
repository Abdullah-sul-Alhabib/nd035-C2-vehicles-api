package com.udacity.vehicles.service;

import com.udacity.vehicles.client.maps.MapsClient;
import com.udacity.vehicles.client.prices.PriceClient;
import com.udacity.vehicles.domain.car.Car;
import com.udacity.vehicles.domain.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implements the car service create, read, update or delete
 * information about vehicles, as well as gather related
 * location and price data when desired.
 */
@Service
public class CarService {

    private final MapsClient mapsClient;
    private final PriceClient priceClient;

    private final CarRepository repository;

    /**
     * Instantiates a new Car service.
     *
     * @param mapsClient  the maps client
     * @param priceClient the price client
     * @param repository  the repository
     */
    public CarService(MapsClient mapsClient, PriceClient priceClient, CarRepository repository) {
        this.mapsClient = mapsClient;
        this.priceClient = priceClient;
        /**
         * Done: Add the Maps and Pricing Web Clients you create
         *   in `VehiclesApiApplication` as arguments and set them here.
         */
        this.repository = repository;
    }


    /**
     * Gathers a list of all vehicles
     *
     * @return a list of all vehicles in the CarRepository
     */
    public List<Car> list() {
        /*
        Thank you for the suggestion for improvement:
        Hey, you could have invoked Pricing and Maps API for each and every vehicle details returned from DB.
         Please address this if time permits. Thanks.
         */
        List<Car> carList = repository.findAll();
        carList.stream().forEach(
                car -> {
                    car.setLocation(mapsClient.getAddress(car.getLocation()));
                    car.setPrice(priceClient.getPrice(car.getId()));
                }
        );
        return carList;
    }

    /**
     * Gets car information by ID (or throws exception if non-existent)
     *
     * @param id the ID number of the car to gather information on
     * @return the requested car's information, including location and price
     */
    public Car findById(Long id) {
        /**
         * Done: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         *   Remove the below code as part of your implementation.
         */

        Optional<Car> temp = repository.findById(id);

        if (temp.isEmpty()) {
            throw new CarNotFoundException();
        }

        Car car = temp.get();
        /**
         * Done: Use the Pricing Web client you create in `VehiclesApiApplication`
         *   to get the price based on the `id` input'
         * Done: Set the price of the car
         * Note: The car class file uses @transient, meaning you will need to call
         *   the pricing service each time to get the price.
         */

        car.setPrice(priceClient.getPrice(car.getId()));

        /**
         * Done: Use the Maps Web client you create in `VehiclesApiApplication`
         *   to get the address for the vehicle. You should access the location
         *   from the car object and feed it to the Maps service.
         * Done: Set the location of the vehicle, including the address information
         * Note: The Location class file also uses @transient for the address,
         * meaning the Maps service needs to be called each time for the address.
         */

        car.setLocation(mapsClient.getAddress(car.getLocation()));
        return car;
    }

    /**
     * Either creates or updates a vehicle, based on prior existence of car
     *
     * @param car A car object, which can be either new or existing
     * @return the new/updated car is stored in the repository
     */
    public Car save(Car car) {
        if (car.getId() != null) {
            return repository.findById(car.getId())
                    .map(carToBeUpdated -> {
                        carToBeUpdated.setDetails(car.getDetails());
                        carToBeUpdated.setLocation(car.getLocation());
                        carToBeUpdated.setCondition(car.getCondition());
                        return repository.save(carToBeUpdated);
                    }).orElseThrow(CarNotFoundException::new);
        }

        return repository.save(car);
    }

    /**
     * Deletes a given car by ID
     *
     * @param id the ID number of the car to delete
     */
    public void delete(Long id) {
        /**
         * Done: Find the car by ID from the `repository` if it exists.
         *   If it does not exist, throw a CarNotFoundException
         */
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new CarNotFoundException();
        }

        /**
         * Done: Delete the car from the repository.
         */


    }
}
