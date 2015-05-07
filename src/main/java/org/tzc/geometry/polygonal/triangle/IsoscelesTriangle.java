package org.tzc.geometry.polygonal.triangle;

import org.tzc.geometry.LineSegment;
import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

import java.util.List;

public class IsoscelesTriangle extends Triangle implements Validable {
    public IsoscelesTriangle(Point a, Point b, Point c) throws GeometryException {
        super(a, b, c);
    }


    private LineSegment base;

    @Override
    public boolean isValid() {
        if (!super.isValid()) return false;

        List<LineSegment> segments = getSegments();

        LineSegment ab = segments.get(0);
        LineSegment bc = segments.get(1);
        LineSegment ca = segments.get(2);

        if ((ab.getLength() - bc.getLength()) < 0.01) {
            base = ca;
            return true;
        }
        if ((bc.getLength() - ca.getLength()) < 0.01) {
            base = ab;
            return true;
        }
        if ((ca.getLength() - ab.getLength()) < 0.01) {
            base = bc;
            return true;
        }

        return false;
    }

    public LineSegment getBase() {
        return base;
    }
}
