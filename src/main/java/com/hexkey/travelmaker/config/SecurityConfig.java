package com.hexkey.travelmaker.config;

import com.hexkey.travelmaker.community.notices.controller.AdminNoticesController;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    // 비밀번호 암호화 제공
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf()
                .disable()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .build();
    }

}
