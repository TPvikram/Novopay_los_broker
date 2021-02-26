package in.novopay.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class NovoBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovoBrokerApplication.class, args);
	}

}
