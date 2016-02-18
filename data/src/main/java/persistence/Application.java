package persistence;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tzc.geometry.factory.ExampleShapeFactory;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.shape.ShapeType;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;

import persistence.repository.LineSegmentRepository;
import persistence.repository.ShapeRepository;
import persistence.services.ShapeService;

@SpringBootApplication
@ComponentScan(basePackages = {"persistence.services"})
@EntityScan(basePackages = "org.tzc.geometry.shape")
@EnableJpaRepositories(basePackages = {"persistence.repository"})
/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
public class Application {

    @Autowired
    private ShapeService shapeService;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(LineSegmentRepository lineSegmentRepository, ShapeRepository shapeRepository) {
        return (args) -> {

            Point a = new Point(5, 7);
            Point b = new Point(1, 10);
            Point c = new Point(0, 0);

            Shape triangle = ExampleShapeFactory.createExampleShape(ShapeType.TRIANGLE);
            shapeService.persist(triangle);
            Triangle newTriangle = (Triangle) shapeRepository.findOne(1L);

            newTriangle.setPoints(Arrays.asList(a, b, c));
            shapeService.update(newTriangle);

            Shape newerTriangle = shapeService.find(1L);

            System.out.println(triangle);

            System.out.println(triangle.equals(newTriangle));
            System.out.println(triangle.equals(newerTriangle));
            System.out.println(newTriangle.equals(newerTriangle));
        };
    }

}
