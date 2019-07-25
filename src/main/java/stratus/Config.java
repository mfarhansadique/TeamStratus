package stratus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories("stratus.data")

public class Config {

    @Bean
    public UserDAO userDao() { return new UserDAOSpring(); }

    @Bean
    public RouteDAO routeDao() { return (RouteDAO) new RouteDAOSpring(); }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean em
                = new LocalEntityManagerFactoryBean();
        em.setPersistenceUnitName("users");
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        return manager;
    }
}


//Do we need MI to show business value??