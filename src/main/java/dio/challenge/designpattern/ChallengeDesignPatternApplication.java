package dio.challenge.designpattern;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "1.0", description = "Uma API utilizando o design pattern Strategy"))
public class ChallengeDesignPatternApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChallengeDesignPatternApplication.class, args);
	}
}
