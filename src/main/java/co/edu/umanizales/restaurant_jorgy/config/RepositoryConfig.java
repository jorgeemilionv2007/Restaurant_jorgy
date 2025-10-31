package co.edu.umanizales.restaurant_jorgy.config;

import co.edu.umanizales.restaurant_jorgy.service.RestaurantRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public RestaurantRepository restaurantRepository() {
        return new RestaurantRepository();
    }
}
