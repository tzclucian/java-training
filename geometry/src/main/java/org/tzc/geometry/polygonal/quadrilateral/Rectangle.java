package org.tzc.geometry.polygonal.quadrilateral;

import org.tzc.geometry.LineSegment;
import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

public class Rectangle extends Parallelogram implements Validable {

    public Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) throws GeometryException {
        super(a, b, c, d);
    }

    @Override
    public boolean check() {
        if (!super.check()) {
            return false;
        }

        LineSegment ab = getSegments().get(0);
        LineSegment bc = getSegments().get(1);

        double angle = ab.calculateAngle(bc);
        double angleDegrees = Math.toDegrees(angle);

        if (Math.abs(angleDegrees - 90) < 0.0001) {
            return true;
        }
        return false;
    }
}
