package persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tzc.geometry.shape.Shape;

import persistence.repository.ShapeRepository;

/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
@Component
public class ShapeService {
    @Autowired
    private ShapeRepository shapeRepository;

    public Shape find(long id) {
        return shapeRepository.findOne(id);
    }

    public Iterable<Shape> findAll(long id) {
        return shapeRepository.findAll();
    }

    public long persist(Shape shape) {
        Shape savedShape = shapeRepository.save(shape);
        return savedShape.getId();
    }

    public long update(Shape shape) {
        Shape updatedShape = shapeRepository.save(shape);
        return updatedShape.getId();
    }

    public void delete(Shape shape) {
        shapeRepository.delete(shape);
    }

    public void delete(long id) {
        shapeRepository.delete(id);
    }
}
