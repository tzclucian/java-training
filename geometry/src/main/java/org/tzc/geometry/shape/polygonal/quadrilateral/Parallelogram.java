package org.tzc.geometry.shape.polygonal.quadrilateral;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
import org.tzc.geometry.exceptions.GeometryException;

public class Parallelogram extends Quadrilateral implements Validable {

    public Parallelogram() {
    }

    public Parallelogram(Point a, Point b, Point c, Point d) throws GeometryException {
        super(a, b, c, d);
    }

    @Override
    public boolean check() {
        if (!super.check()) {
            return false;
        }

        double ab = getSegments().get(0).calculateLength();
        double bc = getSegments().get(1).calculateLength();
        double cd = getSegments().get(2).calculateLength();
        double da = getSegments().get(3).calculateLength();

        if (ab == cd && bc == da) {
            return true;
        }
        return false;
    }
}
