package com.itacademy.configServiceTest;

import com.itacademy.configService.ApplicationConfigurationService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.itacademy.utill")
@Import(ApplicationConfigurationService.class)
public class ApplicationConfigurationServiceTest {
}
