package upqnu.scwhim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScwhimApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScwhimApplication.class, args);
	}

}
