package endpoints;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.layer.CompositeLayer;
import org.tzc.geometry.serializer.JSONSerializer;
import org.tzc.geometry.serializer.LayerAdaptor;
import org.tzc.geometry.serializer.ShapeSerializer;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.shape.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.shape.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.shape.polygonal.quadrilateral.Square;
import org.tzc.geometry.shape.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.shape.polygonal.triangle.RightTriangle;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;

/**
 * @author Lucian Tuca
 *         25/05/15
 *         java-training
 */
@RestController
@EnableAutoConfiguration
public class LayerResource {

    @RequestMapping(value = "/rest/hello-layer", method = RequestMethod.GET)
    public String helloLayer() {
        return "Hello Layer!";
    }

    @RequestMapping(value = "/rest/example-layer", method = RequestMethod.GET)
    public String exampleLayer() throws GeometryException {

        ShapeSerializer jsonSerializer = new JSONSerializer();
        LayerAdaptor shapeAdaptor = new LayerAdaptor(createExampleLayer());
        return shapeAdaptor.serialize(jsonSerializer);
    }

    @RequestMapping(value = "/rest/example-file/{fileName}", method = RequestMethod.GET)
    public void exampleLayerFile(@PathVariable("fileName") String filename, HttpServletResponse response)
            throws GeometryException, IOException {

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("The 'filename' must be not null or empty!");
        }

        ShapeSerializer jsonSerializer = new JSONSerializer();
        LayerAdaptor shapeAdaptor = new LayerAdaptor(createExampleLayer());
        String serializedLayer = shapeAdaptor.serialize(jsonSerializer);

        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setContentType("text/plain");

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(serializedLayer.getBytes(StandardCharsets.UTF_8));
        servletOutputStream.flush();
        servletOutputStream.close();

        response.flushBuffer();
    }

    private CompositeLayer createExampleLayer() throws GeometryException {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral q = new Quadrilateral(a, b, c, d);
        Parallelogram p = new Parallelogram(a, b, c, d);
        Rectangle r = new Rectangle(a, b, c, d);
        Square s = new Square(a, b, c, d);
        Triangle t = new RightTriangle(a, b, c);
        Triangle it = new IsoscelesTriangle(a, b, c);

        CompositeLayer compositeLayer = new CompositeLayer();
        compositeLayer.add(q);
        compositeLayer.add(p);

        CompositeLayer compositeLayer1 = new CompositeLayer();
        compositeLayer1.add(r);
        CompositeLayer compositeLayer2 = new CompositeLayer();
        compositeLayer2.add(s);
        CompositeLayer compositeLayer3 = new CompositeLayer();
        compositeLayer3.add(it);

        compositeLayer1.add(compositeLayer2);
        compositeLayer1.add(t);

        compositeLayer.add(compositeLayer1);
        compositeLayer.add(compositeLayer3);
        return compositeLayer;
    }
}