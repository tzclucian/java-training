package persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"persistence.service", "rest.endpoint"})
@EntityScan(basePackages = "org.tzc.geometry.shape")
@EnableJpaRepositories(basePackages = {"persistence.repository"})
/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
public class PersistenceApp {
    public static void main(String[] args) {
        SpringApplication.run(PersistenceApp.class);
    }
}
