package com.digitalAlpha.gateway.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
/*
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final ReactiveClientRegistrationRepository repository;

    @Bean
    public SecurityWebFilterChain  securityWebFilterChain(ServerHttpSecurity http){
        http.csrf().disable().cors().disable()
                .authorizeExchange(exchange -> exchange.pathMatchers(HttpMethod.POST,"/api/v1/users").permitAll())
                .authorizeExchange(exchange -> exchange.pathMatchers("/actuator").permitAll())
                .authorizeExchange().anyExchange().authenticated()
                .and()
                .oauth2Login(Customizer.withDefaults())
                .logout().logoutSuccessHandler(myLogout())
                .and()
                .oauth2ResourceServer().jwt().jwkSetUri("http://keycloak:8080/realms/digitalMoneyHouse/protocol/openid-connect/certs");
        return http.build();
    }
    private ServerLogoutSuccessHandler myLogout(){
        OidcClientInitiatedServerLogoutSuccessHandler successHandler =
                new OidcClientInitiatedServerLogoutSuccessHandler(repository);
        successHandler.setPostLogoutRedirectUri("http://localhost:8081/oauth2/logout");
        return successHandler;
    }
}

 */
