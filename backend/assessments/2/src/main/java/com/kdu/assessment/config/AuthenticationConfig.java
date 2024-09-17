package com.kdu.assessment.config;

import com.kdu.assessment.security.CustomAuthProvider;
import com.kdu.assessment.security.TokenGeneratorFilter;
import com.kdu.assessment.security.TokenValidatorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
@ComponentScan("com.kdu.assessment.security")
public class AuthenticationConfig {

    private final CustomAuthProvider authProvider;

    @Autowired
    public AuthenticationConfig(CustomAuthProvider authProvider){
        this.authProvider = authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/auth/register").permitAll()
                        .requestMatchers("/cart/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/inventory", "/inventory/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/order").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .anyRequest().authenticated()).csrf().disable();
        http.httpBasic(withDefaults());
        return http.build();
    }

}