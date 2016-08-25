package com.example;

import com.example.service.Add;
import com.example.service.AddService;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class WsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsDemoApplication.class, args);
	}

	@Configuration
	@EnableAutoConfiguration
	@EnableWebMvc
	@ImportResource({"classpath:META-INF/cxf/cxf.xml" })
	@ComponentScan
	@EntityScan
	@EnableJpaRepositories
	public static class  Configure{

		@Autowired
		private ApplicationContext applicationContext;

		@Bean
		public Add addService(){
			return new AddService();
		}

		//use cxf

		@Bean
		public ServletRegistrationBean cxfServlet() {
			return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
		}




		@Bean
		// <jaxws:endpoint id="helloWorld" implementor="demo.spring.service.HelloWorldImpl" address="/HelloWorld"/>
		@Autowired
		public EndpointImpl helloService(Add addService) {
			Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
			Object implementor = addService;
			EndpointImpl endpoint = new EndpointImpl(bus, implementor);
			endpoint.publish("/hello");
			//endpoint.getServer().getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
			//endpoint.getServer().getEndpoint().getOutInterceptors().add(new LoggingOutInterceptor());
			return endpoint;
		}



	}
}
