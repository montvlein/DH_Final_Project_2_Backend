package com.digitalAlpha.gateway.fallbacks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class FallbackFilter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.path("/api/v1/fallback"),
                        this::handleFallback);
    }

    public Mono<ServerResponse> handleFallback(ServerRequest request) {
        Error error = Error.builder()
                .code(HttpStatus.SERVICE_UNAVAILABLE.value())
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .message("this service is unavailable").build();
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(BodyInserters.fromValue(error));
    }
}