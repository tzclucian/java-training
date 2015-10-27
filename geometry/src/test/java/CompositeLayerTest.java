import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.tzc.geometry.builders.LayerBuilder;
import org.tzc.geometry.layer.CompositeLayer;
import org.tzc.geometry.serializer.JSONSerializer;
import org.tzc.geometry.serializer.SerializableLayerAdapter;
import org.tzc.geometry.serializer.ShapeSerializer;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.shape.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.shape.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.shape.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.shape.polygonal.quadrilateral.Square;
import org.tzc.geometry.shape.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.shape.polygonal.triangle.RightTriangle;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompositeLayerTest {

    private ObjectMapper  objectMapper= new ObjectMapper();

    @Test
    public void layerShapesTest() {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral quadrilateral = new Quadrilateral(a, b, c, d);
        Parallelogram parallelogram = new Parallelogram(a, b, c, d);
        Rectangle rectangle = new Rectangle(a, b, c, d);
        Square square = new Square(a, b, c, d);
        Triangle rightTriangle = new RightTriangle(a, b, c);
        Triangle isoscelesTriangle = new IsoscelesTriangle(a, b, c);

        LayerBuilder layerBuilder = new LayerBuilder();
        layerBuilder.addShape(quadrilateral);
        layerBuilder.addShape(parallelogram);
        CompositeLayer compositeLayer = layerBuilder.build();

        assertNotNull(compositeLayer);
        assertEquals(2, compositeLayer.listAllShapes().size());

        CompositeLayer compositeLayer1 = new CompositeLayer();
        compositeLayer1.add(rectangle);
        CompositeLayer compositeLayer2 = new CompositeLayer();
        compositeLayer2.add(square);
        CompositeLayer compositeLayer3 = new CompositeLayer();
        compositeLayer3.add(isoscelesTriangle);

        compositeLayer1.add(compositeLayer2);
        compositeLayer1.add(rightTriangle);

        compositeLayer.add(compositeLayer1);
        compositeLayer.add(compositeLayer3);

        compositeLayer.draw();

        List<Shape> shapes = compositeLayer.listAllShapes();
        assertEquals(6, shapes.size());
    }

    @Test
    public void exportAndImportLayerTest() throws IOException {
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
        compositeLayer.add(t);
        compositeLayer.add(it);

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

        // Exporting
        ShapeSerializer serializer = new JSONSerializer();
        SerializableLayerAdapter layerAdapter = new SerializableLayerAdapter(compositeLayer);
        String serializedLayer = layerAdapter.serialize(serializer);

        // Importing
        CompositeLayer newCompositeLayer = objectMapper.readValue(serializedLayer, CompositeLayer.class);

        assertEquals(compositeLayer.listAllShapes().size(), newCompositeLayer.listAllShapes().size());
    }

    @Test
    public void nullLayerSerializationTest() {
        ShapeSerializer serializer = new JSONSerializer();
        CompositeLayer layer = null;
        SerializableLayerAdapter layerAdapter = new SerializableLayerAdapter(layer);
        String serializedLayer = layerAdapter.serialize(serializer);
        assertEquals("null", serializedLayer);
    }
}
