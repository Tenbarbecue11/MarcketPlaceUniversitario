package com.example.MarcketPlaceUniversitario.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();

        server.setUrl(
                "https://superb-curiosity-production-a149.up.railway.app"
        );

        return new OpenAPI()
                .servers(List.of(server))
                .info(new Info()
                        .title("Marcket Place Universitario")
                        .version("1.0")
                        .description(
                                "API para gestión de equipos, jugadores, partidos y estadísticas"
                        ));
    }
}
