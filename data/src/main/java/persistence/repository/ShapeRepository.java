package persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
public interface ShapeRepository extends CrudRepository<Shape, Long> {
}
