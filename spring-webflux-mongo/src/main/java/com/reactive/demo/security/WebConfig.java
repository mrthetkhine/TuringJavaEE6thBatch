package com.reactive.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;


@Configuration
@EnableWebFluxSecurity
public class WebConfig {

	@Autowired
	JwtService jwtService;
	
	@Autowired
	ReactiveUserDetailsServiceImpl reactiveUserDetailsService;

	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http,
			ReactiveAuthenticationManager authenticationManager,
			ServerAuthenticationConverter authenticationConverter) {
		AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager);
		authenticationWebFilter.setServerAuthenticationConverter(authenticationConverter);

		return http
				.authorizeExchange(
						exchanges -> 
							exchanges.pathMatchers(HttpMethod.POST, "/login")
								.permitAll()
								.pathMatchers(HttpMethod.POST,"/register").hasRole("ADMIN")
								.anyExchange().authenticated()
							)
				.addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.formLogin(ServerHttpSecurity.FormLoginSpec::disable).csrf(ServerHttpSecurity.CsrfSpec::disable)
				.cors(ServerHttpSecurity.CorsSpec::disable).build();
	}
	 
	@Bean
    public JwtAuthenticationManager repositoryReactiveAuthenticationManager() {
	 JwtAuthenticationManager repositoryReactiveAuthenticationManager = new JwtAuthenticationManager(reactiveUserDetailsService, passwordEncoder(),jwtService);
        return repositoryReactiveAuthenticationManager;
    }
	    
}
