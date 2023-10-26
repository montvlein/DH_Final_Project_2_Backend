package com.digitalAlpha.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggerFilters {

    @Bean
    public GlobalFilter filterInLog() {
        return (exchange, chain) -> {
            log.info(exchange.getRequest().toString());
            log.info("Request [" + exchange.getRequest().getId() +"] from: " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> log
                    .info("Response from: " + exchange.getRequest().getPath() + " with status " + exchange.getResponse().getRawStatusCode())));
        };
    }
}
