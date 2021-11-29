package application;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "controllers" })
@EnableJpaRepositories({ "repositories" })
@ComponentScan({ "services" })
@EntityScan({ "models" })
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		 app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8084"));
		        app.run(args);
	}
}
