package persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.tzc.geometry.shape.LineSegment;

/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
public interface LineSegmentRepository extends CrudRepository<LineSegment, Long> {

}
