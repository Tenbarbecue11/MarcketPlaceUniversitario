package com.example.MarcketPlaceUniversitario.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Marcket Place Universitario")
                        .version("1.0")
                        .description("API para gestión de equipos, jugadores, partidos y estadísticas"));
    }
}
