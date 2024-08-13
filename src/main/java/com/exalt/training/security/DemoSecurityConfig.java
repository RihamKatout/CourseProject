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

        // we want to use JDBC authentication, but we don't want to use default tables and columns
        // give queries to access tables
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer.anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );
        return httpSecurity.build();
    }
}