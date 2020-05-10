package io.codewithrkc.trackercovid19v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrackerCovid19V1Application {

	public static void main(String[] args) {
		SpringApplication.run(TrackerCovid19V1Application.class, args);
	}

}
