package com.example.ultravision;

import com.example.mvc.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.DAO")
@EntityScan(basePackages = {"com.example.model"})
@ComponentScan(basePackages = {"com.example.mvc", "com.example.service"})


public class UltravisionApplication {

	public static void main(String[] args) {
//		SpringApplication.run(UltravisionApplication.class, args);

		/*configuration JFRAME in Spring context*/
		ApplicationContext context = new SpringApplicationBuilder(UltravisionApplication.class).headless(false).run(args);
		View a = context.getBean(View.class);
		a.setVisible(true);
	}

}
