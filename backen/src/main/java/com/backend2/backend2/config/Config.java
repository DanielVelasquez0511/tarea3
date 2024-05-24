package com.backend2.backend2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3306") // Escribir la URL del proyecto front a conectar
                .allowedMethods("*") // Podemos especificar los métodos a permitir desde el front
                .allowCredentials(true); // Para que permita las credenciales
    }
}
