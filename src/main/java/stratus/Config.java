package stratus;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("stratus.data")

public class Config {
}


//security configuartions go here

//Do we need MI to show business value??