package org.tzc.geometry.polygonal.quadrilateral;

import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

public class Parallelogram extends Quadrilateral implements Validable {


    public Parallelogram(Point a, Point b, Point c, Point d) throws GeometryException {
        super(a, b, c, d);
    }

    @Override
    public boolean isValid() {
        if (!super.isValid()) {
            return false;
        }

        double ab = getSegments().get(0).getLength();
        double bc = getSegments().get(1).getLength();
        double cd = getSegments().get(2).getLength();
        double da = getSegments().get(3).getLength();

        if (ab == cd && bc == da) {
            return true;
        }
        return false;
    }
}
