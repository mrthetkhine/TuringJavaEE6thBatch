package com.reactive.demo.operator;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.reactive.demo.WaitUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class FetchProfileTest {
	static WebClient client;
	@BeforeAll
	public static void setup(){
		client = WebClient.create("https://api.escuelajs.co/");
	}
	
	Mono<AuthResponse> authLogin(String email,String password)
	{
		log.info("Login");

	    Map<String, String> bodyMap = new HashMap();
	    bodyMap.put("email",email);
	    bodyMap.put("password",password);
	    
		return client.post()
			.uri("api/v1/auth/login")
			.body(BodyInserters.fromValue(bodyMap))
			.retrieve()
			.bodyToMono(AuthResponse.class);
	}
	Mono<Profile> fetchProfile(String token)
	{
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer "+token);
	    
	    
		return client.get()
			.uri("api/v1/auth/profile")
			.headers(h -> h.addAll(headers))
			.retrieve()
			.bodyToMono(Profile.class);
	}
	Mono<Profile> getProfile(String email,String password)
	{
		return this.authLogin(email, password)
					//.log()
					.onErrorMap(exp->{
						return new Exception("Login error");
					})//Mono<AuthResponse>
					.flatMap(authResp-> fetchProfile(authResp.access_token))
					//.log()
					.onErrorMap(exp->{
						return new Exception("Get error in fetching Profile");
					});
	}
	@Test
	public void testAuthLogin()
	{
		/*
		authLogin("john@mail.com","changeme")
			.subscribe(data->{
				log.info("Data "+data.access_token);
				fetchProfile(data.access_token)
					.subscribe(profile->{
						log.info("Profile "+profile);
					},err->{
						log.info("Error at fetching Profile "+err);
					});
			},error->{
				log.info("Error "+error);
			});
		*/	
		getProfile("john@mail.com","changeme1")
				.subscribe(profile->{
					log.info("Profile "+profile);
				},err->{
					log.info("Error  "+err);
				});
		WaitUtil.delay(3000);
	}
	
}
