package dev.harrish.EComUserAuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EComUserAuthServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(EComUserAuthServiceApplication.class, args);
	}

}
