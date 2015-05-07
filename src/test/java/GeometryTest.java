import org.tzc.geometry.Point;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.polygonal.quadrilateral.Square;
import org.tzc.geometry.polygonal.triangle.EquilateralTriangle;
import org.tzc.geometry.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.polygonal.triangle.RightTriangle;
import org.tzc.geometry.polygonal.triangle.Triangle;

public class GeometryTest {
    public static void main(String[] args) throws GeometryException {
        Point a = new Point(0, 0);
        Point b = new Point(20, 0);
        Point c = new Point(20, 20);
        Point d = new Point(0, 20);

//        Quadrilateral q = new Quadrilateral(a, b, c, d);
//        q.draw();
//        System.out.println(q.getArea());
//
//        Parallelogram p = new Parallelogram(a, b, c, d);
//        p.draw();
//        System.out.println(p.getArea());
//
//        Rectangle r = new Rectangle(a, b, c, d);
//        r.draw();
//        System.out.println(r.getArea());
//
//        Square s = new Square(a, b, c, d);
//        s.draw();
//        System.out.println(s.getArea());
//
//
//        Triangle t = new RightTriangle(a, b, c);
//        t.draw();
//        System.out.println(t.getArea());
//
//        Triangle it = new IsoscelesTriangle(a, b, c);
//        it.draw();
//        System.out.println(it.getArea());

        Point A = new Point(0, 0);
        Point B = new Point(500, 0);
        Point C = new Point(250, 500 * Math.sqrt(3)/2);

        Triangle et = new EquilateralTriangle(A, B, C);
        et.draw();
        System.out.println(et.getArea());

    }
}
