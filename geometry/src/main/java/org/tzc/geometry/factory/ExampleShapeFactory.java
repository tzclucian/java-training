package org.tzc.geometry.factory;

import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.shape.ShapeType;
import org.tzc.geometry.shape.polygonal.Polygon;
import org.tzc.geometry.shape.polygonal.PolygonalPath;
import org.tzc.geometry.shape.polygonal.quadrilateral.Parallelogram;
import org.tzc.geometry.shape.polygonal.quadrilateral.Quadrilateral;
import org.tzc.geometry.shape.polygonal.quadrilateral.Rectangle;
import org.tzc.geometry.shape.polygonal.quadrilateral.Square;
import org.tzc.geometry.shape.polygonal.triangle.EquilateralTriangle;
import org.tzc.geometry.shape.polygonal.triangle.IsoscelesTriangle;
import org.tzc.geometry.shape.polygonal.triangle.RightTriangle;
import org.tzc.geometry.shape.polygonal.triangle.Triangle;
import org.tzc.geometry.shape.rounded.Circle;

/**
 * @author Lucian Tuca
 *         13/10/15
 *         java-training
 *
 *         Factory class.
 */
public class ExampleShapeFactory {
    public static Shape createExampleShape(ShapeType shapeType) {
        Point a, b, c, d, e;
        switch (shapeType) {
            case PARALLELOGRAM:
                a = new Point(0, 0);
                b = new Point(40, 0);
                c = new Point(60, 20);
                d = new Point(20, 20);
                return new Parallelogram(a, b, c, d);
            case QUADRILATERAL:
                a = new Point(0, 0);
                b = new Point(35, 20);
                c = new Point(-5, 40);
                d = new Point(-10, 25);
                return new Quadrilateral(a, b, c, d);
            case RECTANGLE:
                a = new Point(0, 0);
                b = new Point(50, 0);
                c = new Point(50, 30);
                d = new Point(0, 30);
                return new Rectangle(a, b, c, d);
            case SQUARE:
                a = new Point(0, 0);
                b = new Point(25, 0);
                c = new Point(25, 25);
                d = new Point(0, 25);
                return new Square(a, b, c, d);
            case EQUILATERAL_TRIANGLE:
                a = new Point(0, 0);
                b = new Point(50, 0);
                c = new Point(25, 50 * Math.sqrt(3) / 2);
                return new EquilateralTriangle(a, b, c);
            case ISOSCELES_TRIANGLE:
                a = new Point(20, 20);
                b = new Point(10, 0);
                c = new Point(30, 0);
                return new IsoscelesTriangle(a, b, c);
            case RIGHT_TRIANGLE:
                a = new Point(0, 0);
                b = new Point(25, 0);
                c = new Point(0, 15);
                return new RightTriangle(a, b, c);
            case TRIANGLE:
                a = new Point(0, 0);
                b = new Point(25, 5);
                c = new Point(5, 15);
                return new Triangle(a, b, c);
            case POLYGON:
                a = new Point(0, 0);
                b = new Point(20, 20);
                c = new Point(50, -10);
                d = new Point(60, 10);
                e = new Point(30, 15);
                return new Polygon(a, b, c, d, e);
            case POLYGONAL_PATH:
                a = new Point(0, 0);
                b = new Point(20, 20);
                c = new Point(50, -10);
                d = new Point(60, 10);
                e = new Point(30, 15);
                return new PolygonalPath(a, b, c, d, e);
            case CIRCLE:
                c = new Point(10, 10);
                long radiusLength = 8;
                return new Circle(c, radiusLength);
            default:
                throw new GeometryException("Provided shape type could not be recognized");
        }
    }
}
