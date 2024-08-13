package com.exalt.training.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails riham = User.builder()
//                .username("riham")
//                .password("{noop}1218")
//                .roles("MANAGER", "ADMIN")
//                .build();
//
//        UserDetails ahmad = User.builder()
//                .username("ahmad")
//                .password("{noop}2010")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails siwar = User.builder()
//                .username("siwar")
//                .password("{noop}2021}")
//                .roles("MANAGER", "EMPLOYEE")
//                .build();
//
//        return new InMemoryUserDetailsManager(riham, siwar, ahmad);
//        //Since we defined our users here, spring will not use users in properties file
//    }
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        // create users, authorities tables
        // authorities must start with ROLE_**
        // this method tell spring to use JDBC authentication with our data source
        return new JdbcUserDetailsManager((dataSource));
    }
    // For restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}