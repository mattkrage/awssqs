package com.mathieu.awssqs;

import com.mathieu.awssqs.config.Consumer;
import com.mathieu.awssqs.config.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class AwssqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwssqsApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(Publisher publisher, Consumer consumer) {


		return args -> {
			Thread.sleep(3000);
			for (int i = 0; i < 10; i++) {
				publisher.publishMessage(String.valueOf(i));
			}
			Thread.sleep(3000);
			consumer.consumeMessages();
		};
	}


}
