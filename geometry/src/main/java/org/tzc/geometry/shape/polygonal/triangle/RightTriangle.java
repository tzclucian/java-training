package org.tzc.geometry.shape.polygonal.triangle;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;

@Entity
@Table(name = "RIGHT_TRIANGLE")
public class RightTriangle extends Triangle implements Validable {

    @Embedded
    private Point rightAngle;

    public RightTriangle() {
    }

    public RightTriangle(Point a, Point b, Point c) {
        super(a, b, c);
    }

    @Override
    public boolean check() {
        if (!super.check()) return false;

        List<LineSegment> segments = getSegments();


        double ab = segments.get(0).calculateLength();
        double bc = segments.get(1).calculateLength();
        double ca = segments.get(2).calculateLength();

        double max = Math.max(Math.max(ab, bc), ca);
        double hypotenuse = Math.pow(max, 2);

        if (Math.abs(hypotenuse - (Math.pow(ab, 2) + Math.pow(bc, 2))) < 0.0001) {
            rightAngle = getPoints().get(1);
            return true;
        }

        if (Math.abs(hypotenuse - (Math.pow(ab, 2) + Math.pow(ca, 2))) < 0.0001) {
            rightAngle = getPoints().get(0);
            return true;
        }

        if (Math.abs(hypotenuse - (Math.pow(ca, 2) + Math.pow(bc, 2))) < 0.0001) {
            rightAngle = getPoints().get(2);
            return true;
        }

        return false;
    }

    public Point getRightAngle() {
        if (rightAngle == null) {
            if (!check()) {
                throw new GeometryException("Not a right triangle");
            }
        }
        return rightAngle;
    }
}
