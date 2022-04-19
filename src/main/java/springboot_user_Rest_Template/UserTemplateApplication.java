package springboot_user_Rest_Template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserTemplateApplication {

	public static void main(String[] args) {
	SpringApplication.run(UserTemplateApplication.class, args);
	}
	
	@Bean     //doubt
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
