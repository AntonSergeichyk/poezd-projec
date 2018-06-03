package com.itacademy.utill;

import com.itacademy.configService.ApplicationConfigurationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class BeanUtill {

    public static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ApplicationConfigurationService.class);

    public static <T extends Object> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
