package com.javaee6.webmvc.demo.config;

import java.time.Duration;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebClientConfig  implements WebMvcConfigurer{
	@Value("${todo.baseURI}")
	String baseURI;

	@Value("${webclient.connecttimeout}")
	long connectTimeout;

	@Value("${webclient.sockettimeout}")
	long socketTimeout;

	@Value("${webclient.requesttimeout}")
	long requestTimeout;

	@Value("${webclient.readTimeout}")
	long readTimeout;

	@Bean
	RestClient restClient() {
	  return RestClient
			  .builder()
			  .requestFactory(getClientHttpRequestFactory())
			  .baseUrl(baseURI)
			  .build();

	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		log.info("getClientHttpRequestFactory");
		/*
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(300);
		factory.setReadTimeout(3000);
		*/


        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(connectTimeout))
                .build();

        // Socket timeout, read timeout
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(Timeout.ofMilliseconds(socketTimeout))
                .build();

        // Connection request timeout
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(requestTimeout))
                .build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultSocketConfig(socketConfig);
        connectionManager.setDefaultConnectionConfig(connectionConfig);

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();


		HttpComponentsClientHttpRequestFactory factory =new HttpComponentsClientHttpRequestFactory(httpClient);
		//read timeout
		factory.setConnectionRequestTimeout(Duration.ofMillis(readTimeout));
		factory.setConnectTimeout((int)connectTimeout);



        return factory;
    }
}
