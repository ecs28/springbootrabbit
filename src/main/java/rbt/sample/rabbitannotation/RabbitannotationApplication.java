package rbt.sample.rabbitannotation;

import java.util.Arrays;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import rbt.sample.rabbitannotation.factory.QueueFactory;

@SpringBootApplication
@Import({ QueueFactory.class})
@EnableRabbit
public class RabbitannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitannotationApplication.class, args);
	}
	
	// show beans injected
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	
}
