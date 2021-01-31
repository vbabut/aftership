package com.aftership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@PropertySource("classpath:application.properties")
public class AfterShipApplication extends SpringBootServletInitializer {
public static void main(String[] args) {
	
SpringApplication.run(AfterShipApplication.class, args);
}

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder sp)
{
	
	return sp.sources(AfterShipApplication.class);


}

}