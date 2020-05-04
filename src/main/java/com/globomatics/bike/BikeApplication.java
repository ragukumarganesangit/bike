package com.globomatics.bike;

import com.globomatics.bike.service.HerokuNotIdle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class BikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeApplication.class, args);
	}

	@Bean
	public HerokuNotIdle herokuNotIdle(){
		return new HerokuNotIdle();
	}

}
