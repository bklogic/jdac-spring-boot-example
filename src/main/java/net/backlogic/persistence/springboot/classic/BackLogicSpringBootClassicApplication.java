package net.backlogic.persistence.springboot.classic;

import net.backlogic.persistence.springboot.DataAccessProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BackLogicSpringBootClassicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackLogicSpringBootClassicApplication.class, args);
	}

}
