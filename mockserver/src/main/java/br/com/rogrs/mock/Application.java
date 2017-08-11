package br.com.rogrs.mock;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.tomakehurst.wiremock.WireMockServer;

@SpringBootApplication
@EnableScheduling
public class Application {
	

    public static void main(String[] args) {
    

    	WireMockServer wm = new WireMockServer(options().port(2345));
    	
        SpringApplication.run(Application.class, args);
    }

	
}