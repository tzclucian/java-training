import org.junit.Test;
import org.tzc.geometry.Point;
import org.tzc.geometry.Shape;
import org.tzc.geometry.layer.LayerAdaptor;
import org.tzc.geometry.layer.CompositeLayer;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.polygonal.quadrilateral.Square;
import org.tzc.geometry.polygonal.triangle.EquilateralTriangle;
import org.tzc.geometry.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.polygonal.triangle.RightTriangle;
import org.tzc.geometry.polygonal.triangle.Triangle;
import org.tzc.geometry.visitor.JSONSerializer;
import org.tzc.geometry.visitor.ShapeSerializer;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeometryTest {

    @Test
    public void layerShapesTest() throws GeometryException {
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

        compositeLayer.draw();

        List<Shape> shapes = compositeLayer.listAllShapes();
        assertEquals(6, shapes.size());
    }

    @Test
    public void shapesAreaTest() throws GeometryException {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral q = new Quadrilateral(a, b, c, d);
        q.draw();
        assertEquals(400.0, q.getArea(), 0.01);

        Parallelogram p = new Parallelogram(a, b, c, d);
        p.draw();
        assertEquals(400.0, p.getArea(), 0.01);

        Rectangle r = new Rectangle(a, b, c, d);
        r.draw();
        assertEquals(400.0, r.getArea(), 0.01);

        Square s = new Square(a, b, c, d);
        s.draw();
        assertEquals(400.0, s.getArea(), 0.01);

        Triangle t = new RightTriangle(a, b, c);
        t.draw();
        assertEquals(200, t.getArea(), 0.01);

        Triangle it = new IsoscelesTriangle(a, b, c);
        it.draw();
        assertEquals(200, it.getArea(), 0.01);

        Point A = new Point(0, 0);
        Point B = new Point(50, 0);
        Point C = new Point(25, 50 * Math.sqrt(3) / 2);

        Triangle et = new EquilateralTriangle(A, B, C);
        et.draw();
        assertEquals(1082.53, et.getArea(), 0.01);
    }

    @Test
    public void visitorTest() throws GeometryException {
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

        ShapeSerializer serializer = new JSONSerializer();
        LayerAdaptor shapeAdaptor = new LayerAdaptor(compositeLayer);
        System.out.println(shapeAdaptor.serialize(serializer));
    }
}
