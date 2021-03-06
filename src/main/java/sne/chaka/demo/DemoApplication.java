package sne.chaka.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import sne.chaka.demo.config.HelloProperties;
import sne.chaka.demo.domain.repository.UserRepository;

@EnableConfigurationProperties(HelloProperties.class)
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * List Spring Beanprovided by Boot
	 */
	// @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx, UserRepository userRepository) {
		return args -> {
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			log.info("Let's inspect the beans provided by Spring Boot:");
			log.info("-------------------------------");
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
