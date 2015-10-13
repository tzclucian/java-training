package org.tzc.geometry.shape.polygonal.triangle;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.polygonal.SimplePolygon;

import java.util.Arrays;
import java.util.List;

public class Triangle extends SimplePolygon implements Validable {

    public Triangle() {
    }

    public Triangle(Point a, Point b, Point c) throws GeometryException {
        super(Arrays.asList(a, b, c));
    }

    public boolean check() {

        if (!super.check()) {
            return false;
        }

        List<Point> points = getPoints();
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();

        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();

        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        return Math.abs((y1 - y2) * (x1 - x3) - (y1 - y3) * (x1 - x2)) > 0.0001;
    }
}
