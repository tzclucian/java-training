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

public class MiscGeometryTest {

    @Test
    public void shapesAreaTest() {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

        Quadrilateral quadrilateral = new Quadrilateral(a, b, c, d);
        quadrilateral.draw();
        assertEquals(400.0, quadrilateral.calculateArea(), 0.01);

        Parallelogram parallelogram = new Parallelogram(a, b, c, d);
        parallelogram.draw();
        assertEquals(400.0, parallelogram.calculateArea(), 0.01);

        Rectangle rectangle = new Rectangle(a, b, c, d);
        rectangle.draw();
        assertEquals(400.0, rectangle.calculateArea(), 0.01);

        Square square = new Square(a, b, c, d);
        square.draw();
        assertEquals(400.0, square.calculateArea(), 0.01);

        Triangle rightTriangle = new RightTriangle(a, b, c);
        rightTriangle.draw();
        assertEquals(200, rightTriangle.calculateArea(), 0.01);

        Triangle isoscelesTriangle = new IsoscelesTriangle(a, b, c);
        isoscelesTriangle.draw();
        assertEquals(200, isoscelesTriangle.calculateArea(), 0.01);

        Point A = new Point(0, 0);
        Point B = new Point(50, 0);
        Point C = new Point(25, 50 * Math.sqrt(3) / 2);

        Triangle equilateralTriangle = new EquilateralTriangle(A, B, C);
        equilateralTriangle.draw();
        assertEquals(1082.53, equilateralTriangle.calculateArea(), 0.01);
    }


}
