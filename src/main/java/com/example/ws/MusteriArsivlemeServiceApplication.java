package com.example.ws;

import com.example.ws.config.DbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DbConfiguration.class})
public class MusteriArsivlemeServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MusteriArsivlemeServiceApplication.class, args);

	}

}