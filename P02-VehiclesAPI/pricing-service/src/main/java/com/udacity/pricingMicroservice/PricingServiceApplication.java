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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

    private static BigDecimal randomPrice() {
        return BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal("5000")).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Init database command line runner.
     *
     * @param repository the repository
     * @return the command line runner
     */
//Since PricingService is not used, the following will initialize the db with random values
    @Bean
    CommandLineRunner initDatabase(PriceRepository repository) {
        return args -> {
            List<Price> priceList = LongStream
                    .range(1, 21)
                    .mapToObj(i -> new Price(i, "USD", randomPrice(), i))
                    .collect(Collectors.toList());
            repository.saveAll(priceList);
        };
    }
}
