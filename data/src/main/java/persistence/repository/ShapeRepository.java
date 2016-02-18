package persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.tzc.geometry.shape.Shape;

public interface ShapeRepository extends CrudRepository<Shape, Long> {
}
