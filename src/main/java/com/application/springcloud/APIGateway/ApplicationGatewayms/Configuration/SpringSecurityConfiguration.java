package com.application.springcloud.APIGateway.ApplicationGatewayms.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean("SecurityFilterChain")
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
         http.authorizeHttpRequests((request) -> request
                .requestMatchers("/customer/").authenticated())
                 .authorizeHttpRequests((req) -> req.requestMatchers("/").permitAll());

         return http.build();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
         UserDetails user = User.withUsername("admin")
                .password("admin")
                .roles("User")
                .build();

         return new InMemoryUserDetailsManager(user);
    }
}
