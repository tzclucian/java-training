package persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.tzc.geometry.shape.LineSegment;

public interface LineSegmentRepository extends CrudRepository<LineSegment, Long> {

}
