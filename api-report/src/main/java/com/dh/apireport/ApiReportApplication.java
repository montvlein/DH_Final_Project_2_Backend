package com.dh.apireport;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
        servers = {
                @Server(url = "/", description = "Default Server URL")
        }
)

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients
//@EnableEurekaClient
public class ApiReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiReportApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Esto permite CORS para todas las rutas.
                    .allowedOriginPatterns("*")  // Permite solicitudes desde cualquier origen.
                    .allowCredentials(true)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Permite estos métodos HTTP.
                    .allowedHeaders("*"); // Permite todos los encabezados en la solicitud.
//                    .maxAge(3600);
        }

    }

}
