package com.loski.share.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.loski.share.springboot"})
public class LoskiShareApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(LoskiShareApplication.class, args);
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		return application.sources(LoskiShareApplication.class);
		
	}

}
