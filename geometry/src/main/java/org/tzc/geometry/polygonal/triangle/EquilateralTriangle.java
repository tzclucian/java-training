package org.tzc.geometry.polygonal.triangle;

import org.tzc.geometry.LineSegment;
import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;

import java.util.List;

public class EquilateralTriangle extends IsoscelesTriangle implements Validable {

    public EquilateralTriangle() {
    }

    public EquilateralTriangle(Point a, Point b, Point c) throws GeometryException {
        super(a, b, c);
    }

    @Override
    public boolean check() {
        if (!super.check()) return false;

        List<LineSegment> segments = getSegments();

        LineSegment ab = segments.get(0);
        LineSegment bc = segments.get(1);
        LineSegment ca = segments.get(2);

        if ((ab.calculateLength() - bc.calculateLength()) < 0.01 && (bc.calculateLength() - ca.calculateLength()) < 0.01) {
            return true;
        }
        return false;
    }
}
