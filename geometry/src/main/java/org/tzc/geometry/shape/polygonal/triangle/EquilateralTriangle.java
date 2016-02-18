package org.tzc.geometry.shape.polygonal.triangle;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;

@Entity
@Table(name = "EQUILATERAL_TRIANGLE")
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

        return (ab.calculateLength() - bc.calculateLength()) < 0.01 && (bc.calculateLength() - ca.calculateLength()) < 0.01;
    }
}
