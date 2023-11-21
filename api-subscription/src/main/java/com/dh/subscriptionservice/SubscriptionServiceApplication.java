package com.dh.subscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
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
					.allowedHeaders("*") // Permite todos los encabezados en la solicitud.
					.maxAge(3600);

		}
	}
}
