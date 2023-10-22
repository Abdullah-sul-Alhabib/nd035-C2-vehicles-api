package com.udacity.boogle.maps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Maps controller.
 */
@RestController
@RequestMapping("/maps")
public class MapsController {

    /**
     * Get address.
     *
     * @param lat the lat
     * @param lon the lon
     * @return the address
     */
    @GetMapping
    public Address get(@RequestParam Double lat, @RequestParam Double lon) {
        return MockAddressRepository.getRandom();
    }
}
