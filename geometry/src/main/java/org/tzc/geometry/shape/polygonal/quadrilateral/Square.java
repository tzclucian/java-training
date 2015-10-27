package org.tzc.geometry.shape.polygonal.quadrilateral;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;

public class Square extends Rectangle implements Validable {

    public Square() {
    }

    public Square(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
    }

    @Override
    public boolean check() {
        if (!super.check()) {
            return false;
        }

        double ab = getSegments().get(0).calculateLength();
        double bc = getSegments().get(1).calculateLength();

        return ab == bc;
    }
}
