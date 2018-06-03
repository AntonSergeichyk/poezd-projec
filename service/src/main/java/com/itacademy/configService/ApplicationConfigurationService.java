package com.itacademy.configService;

import com.itacademy.config.ApplicationConfigurationRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.itacademy.service")
@Import(ApplicationConfigurationRepository.class)
public class ApplicationConfigurationService {
}














