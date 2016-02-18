package persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tzc.geometry.shape.LineSegment;

import persistence.repository.LineSegmentRepository;

/**
 * @author Lucian Tuca
 *         18/02/16
 *         spring-data-jpa (http://projects.spring.io/spring-data-jpa/)
 */
@Service
public class LineSegmentService {
    @Autowired
    private LineSegmentRepository lineSegmentRepository;

    public LineSegment find(long id) {
        return lineSegmentRepository.findOne(id);
    }

    public Iterable<LineSegment> findAll(long id) {
        return lineSegmentRepository.findAll();
    }

    public long persist(LineSegment lineSegment) {
        LineSegment savedLineSegment = lineSegmentRepository.save(lineSegment);
        return savedLineSegment.getId();
    }

    public long update(LineSegment lineSegment) {
        LineSegment updatedLineSegment = lineSegmentRepository.save(lineSegment);
        return updatedLineSegment.getId();
    }

    public void delete(LineSegment lineSegment) {
        lineSegmentRepository.delete(lineSegment);
    }

    public void delete(long id) {
        lineSegmentRepository.delete(id);
    }
}
