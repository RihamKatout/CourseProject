package com.exalt.training.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails riham = User.builder()
                .username("riham")
                .password("{noop}1218")
                .roles("MANAGER", "ADMIN")
                .build();

        UserDetails ahmad = User.builder()
                .username("ahmad")
                .password("{noop}2010")
                .roles("EMPLOYEE")
                .build();

        UserDetails siwar = User.builder()
                .username("siwar")
                .password("{noop}2021}")
                .roles("MANAGER", "EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(riham, siwar, ahmad);
        //Since we defined our users here, spring will not use users in properties file
    }
}