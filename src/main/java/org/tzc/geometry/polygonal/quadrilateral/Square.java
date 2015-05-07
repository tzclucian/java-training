package org.tzc.geometry.polygonal.quadrilateral;

import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

public class Square extends Rectangle implements Validable {
    public Square(Point a, Point b, Point c, Point d) throws GeometryException {
        super(a, b, c, d);
    }

    @Override
    public boolean isValid() {
        if (!super.isValid()) {
            return false;
        }

        double ab = getSegments().get(0).getLength();
        double bc = getSegments().get(1).getLength();

        if (ab != bc) return false;
        return true;
    }
}
