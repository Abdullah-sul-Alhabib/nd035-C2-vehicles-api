package com.udacity.pricingMicroservice;

import com.udacity.pricingMicroservice.entity.Price;
import com.udacity.pricingMicroservice.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * Done: Convert the application from a REST API to a microservice.
 */
@SpringBootApplication
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

    //Since PricingService is not used, the following will initialize the db with random values
    @Bean
    CommandLineRunner initDatabase(PriceRepository repository) {
        return args -> {
            List<Price> priceList = LongStream
                    .range(1, 21)
                    .mapToObj(i -> new Price(i,"SAR", randomPrice(), i))
                    .collect(Collectors.toList());
            repository.saveAll(priceList);
        };
    }

    private static BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
    }
}
