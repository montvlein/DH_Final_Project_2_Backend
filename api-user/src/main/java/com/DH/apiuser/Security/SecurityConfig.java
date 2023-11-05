package com.DH.apiuser.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
    private UserServiceSecurity userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder(12);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("*******************************************************************");
        //http.cors().and().csrf().disable()
        http.headers().frameOptions().sameOrigin().and().cors().and().csrf().disable()
                .authorizeRequests()
                //.antMatchers("/**").permitAll()//poner el controller sin token
                .antMatchers(HttpMethod.POST, "/user/**").permitAll()
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .antMatchers(HttpMethod.GET, "/user/**").permitAll()
                //.antMatchers(HttpMethod.POST,"/reserva/**", "/producto/**", "/categorias/**","/ciudades/**", "/caracteristicas/**", "/politicas/**").authenticated()
               .antMatchers(HttpMethod.DELETE,"/user/**").authenticated()
                //.antMatchers(HttpMethod.PUT, "/producto/**", "/categorias/**").authenticated()
                .anyRequest()
                .authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // AUTENTICACION DE PRUEBAS SIN USER DESDE BD
        /*
        auth
                .inMemoryAuthentication()
                .withUser("user")
                    .password("12345")
                    .roles("USER")
                    .and()
                .withUser("admin")
                    .password("admin")
                    .roles("USER","ADMIN");
           */

        // AUTENTICACION CONECTADA A LOS USUARIOS DE BD
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
