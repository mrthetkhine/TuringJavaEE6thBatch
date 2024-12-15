package com.reactive.demo.security;

import java.util.List;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


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
				.cors(cors -> cors
                        .configurationSource(corsConfigurationSource()))
				.authorizeExchange(
						exchanges -> 
							exchanges.pathMatchers(HttpMethod.POST, "/login")
								.permitAll()
								
								.pathMatchers(HttpMethod.GET, "/api/movies/**")
								.permitAll()
								.pathMatchers(HttpMethod.POST, "/api/movies/**")
								.permitAll()
								.pathMatchers(HttpMethod.PUT, "/api/movies/**")
								.permitAll()
								.pathMatchers(HttpMethod.DELETE, "/api/movies/**")
								.permitAll()
								
								.pathMatchers(HttpMethod.POST,"/register").hasRole("ADMIN")
								.anyExchange().authenticated()
							)
				//.addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.formLogin(ServerHttpSecurity.FormLoginSpec::disable).csrf(ServerHttpSecurity.CsrfSpec::disable)
				//.cors(ServerHttpSecurity.CorsSpec::disable)
				//.cors().disable()
				.build();
	}
	private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT",
                                       "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Access-Control-Allow-Origin", 
                                       "Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    } 
	@Bean
    public JwtAuthenticationManager repositoryReactiveAuthenticationManager() {
	 JwtAuthenticationManager repositoryReactiveAuthenticationManager = new JwtAuthenticationManager(reactiveUserDetailsService, passwordEncoder(),jwtService);
        return repositoryReactiveAuthenticationManager;
    }
	    
}
