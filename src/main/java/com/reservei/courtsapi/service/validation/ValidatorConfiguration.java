package com.reservei.courtsapi.service.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public List<Validator> validators() {
        return List.of(
                new CategoryValidator());
    }
}
