package com.annapurna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable()) // New syntax
	            .authorizeHttpRequests(auth -> auth
	            		.requestMatchers("/signin", "/signup").permitAll()
	            		);
	        return http.build();
	    }
	
}


//@Bean
//public SecurityFilterChain configureAuthorization(HttpSecurity http) throws Exception {
//    http
//        
//        .csrf(csrf -> csrf.disable())
//        .authorizeHttpRequests(auth -> auth
//            .requestMatchers("/admin/**", "/daywiseOrder/**").hasRole("ADMIN")
//            .requestMatchers("/deliveryboy/**").hasRole("DELIVERYBOY")
//            .requestMatchers("/user/**").hasRole("USER")
//            .requestMatchers("/signin", "/signup", "/roles", "/sendotp", "/resetPassword", "/images/**").permitAll()
//            .requestMatchers(HttpMethod.OPTIONS).permitAll()
//            .anyRequest().authenticated()
//        )
//        .sessionManagement(session -> session
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        )
//        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//
//    return http.build();
//}
