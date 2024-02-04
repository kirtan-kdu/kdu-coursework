package com.kdu.smarthome.config;

import com.kdu.smarthome.security.CustomAuthManager;
import com.kdu.smarthome.security.TokenGeneratorFilter;
import com.kdu.smarthome.security.TokenValidatorFilter;
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
@ComponentScan("com.kdu.smartHome.security")
public class SecurityConfig {

    private final CustomAuthManager customAuthManager;
    @Autowired
    public SecurityConfig(CustomAuthManager authManager){
        this.customAuthManager = authManager;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthManager);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new TokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .antMatchers("/api/v1/auth/register").permitAll()
                        .antMatchers("/swagger-ui/**", "/swagger-resources/**").permitAll()
//                        .requestMatchers("/user/getAll", "user/get").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/user/add").hasRole("ADMIN")
                        .anyRequest().authenticated()).csrf().disable();
        http.httpBasic(withDefaults());
        return http.build();
    }

}
