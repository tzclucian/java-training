import org.junit.Test;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.shape.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.shape.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.shape.polygonal.quadrilateral.Square;
import org.tzc.geometry.shape.polygonal.triangle.EquilateralTriangle;
import org.tzc.geometry.shape.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.shape.polygonal.triangle.RightTriangle;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;

import static org.junit.Assert.assertEquals;

public class GeometryTest {

    @Test
    public void shapesAreaTest() {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral q = new Quadrilateral(a, b, c, d);
        q.draw();
        assertEquals(400.0, q.calculateArea(), 0.01);

        Parallelogram p = new Parallelogram(a, b, c, d);
        p.draw();
        assertEquals(400.0, p.calculateArea(), 0.01);

        Rectangle r = new Rectangle(a, b, c, d);
        r.draw();
        assertEquals(400.0, r.calculateArea(), 0.01);

        Square s = new Square(a, b, c, d);
        s.draw();
        assertEquals(400.0, s.calculateArea(), 0.01);

        Triangle t = new RightTriangle(a, b, c);
        t.draw();
        assertEquals(200, t.calculateArea(), 0.01);

        Triangle it = new IsoscelesTriangle(a, b, c);
        it.draw();
        assertEquals(200, it.calculateArea(), 0.01);

        Point A = new Point(0, 0);
        Point B = new Point(50, 0);
        Point C = new Point(25, 50 * Math.sqrt(3) / 2);

        Triangle et = new EquilateralTriangle(A, B, C);
        et.draw();
        assertEquals(1082.53, et.calculateArea(), 0.01);
    }


}
