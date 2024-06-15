package org.singhav.graphql.config;

import org.singhav.graphql.entity.ProductEntity;
import org.singhav.graphql.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class DatabaseConfig {

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            List<ProductEntity> products = List.of(
                    new ProductEntity("Laptop", "Electronics", 74999.99f, 50),
                    new ProductEntity("Smartphone", "Electronics", 39999.99f, 100),
                    new ProductEntity("Office Chair", "Furniture", 7999.99f, 200),
                    new ProductEntity("Notebook", "Stationery", 99.99f, 500),
                    new ProductEntity("Desk Lamp", "Furniture", 1999.99f, 150),
                    new ProductEntity("Water Bottle", "Accessories", 499.99f, 300));
            productRepository.saveAll(products);
        };
    }
}
