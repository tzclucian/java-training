package rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tzc.geometry.shape.Shape;

import persistence.service.ShapeService;

/**
 * @author Lucian Tuca
 *         18/02/16
 *         java-training
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/geometry/shape")
public class ShapeEndpoint {

    @Autowired
    private ShapeService shapeService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    long createShape(@RequestBody Shape shape) {
        return shapeService.persist(shape);
    }

    @RequestMapping(value = "/{shapeId}", method = RequestMethod.GET)
    Shape readShape(@PathVariable long shapeId) {
        return shapeService.find(shapeId);
    }

    @RequestMapping(value = "/{shapeId}", method = RequestMethod.PUT)
    void updateShape(@PathVariable long shapeId, @RequestBody Shape newShape) {
        Shape existingShape = shapeService.find(shapeId);
        if (existingShape != null) {
            newShape.setId(existingShape.getId());
            shapeService.update(newShape);
        }
    }

    @RequestMapping(value = "/{shapeId}", method = RequestMethod.DELETE)
    void deleteShape(@PathVariable long shapeId) {
        shapeService.delete(shapeId);
    }
}