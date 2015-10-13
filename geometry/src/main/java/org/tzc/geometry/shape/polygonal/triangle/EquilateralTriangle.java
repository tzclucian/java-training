package org.tzc.geometry.shape.polygonal.triangle;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
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
