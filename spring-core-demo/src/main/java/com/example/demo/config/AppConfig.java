package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.bean.ExampleBean;
import com.example.demo.bean.HelloMessageGenerator;
import com.example.demo.bean.PrototypeScopeBean;
import com.example.demo.servlet.HelloWorldServlet;

import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public ExampleBean exampleBean() {
		log.info("Invoke via factory method");
		return new ExampleBean();
	}

	@Bean(name = "prototypeBean")
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public PrototypeScopeBean createPrototype() {
		log.info("Create Prototype bean ");
		return new PrototypeScopeBean();
	}
	
	@Bean
	@RequestScope
	public HelloMessageGenerator requestScopedBean() {
		log.info("HelloMessageBean created ");
		return new HelloMessageGenerator();
	}
	@Bean
	public ServletRegistrationBean<HttpServlet> helloServlet() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new HelloWorldServlet());
		servRegBean.addUrlMappings("/hello/*");
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}
}
