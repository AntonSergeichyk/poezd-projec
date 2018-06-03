package com.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.itacademy.utill")
@Import(ApplicationConfigurationRepository.class)
public class TestConfiguration {

}
