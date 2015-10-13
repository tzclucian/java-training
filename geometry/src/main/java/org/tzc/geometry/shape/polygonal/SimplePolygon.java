package org.tzc.geometry.shape.polygonal;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
import org.tzc.geometry.exceptions.GeometryException;

import java.util.List;

public abstract class SimplePolygon extends Polygon implements Validable {

    public SimplePolygon() {
    }

    public SimplePolygon(List<Point> points) throws GeometryException {
        super(points);

        if (!check()) {
            throw new GeometryException("Invalid " + getClass().getSimpleName());
        }
    }

    public boolean check() {
        List<LineSegment> segments = getSegments();
        int n = segments.size();
        for (int i = 0; i < n; i++) {
            for (int j = (i + 2) % n; j < (i + n - 1) % n; j++) {
                if (segments.get(i).getIntersectionPoint(segments.get(j)) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public double calculateArea() throws GeometryException {
        List<Point> points = getPoints();

        double area = 0;
        int j = points.size() - 1;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point oldPoint = points.get(j);
            area += (oldPoint.getX() + currentPoint.getX()) * (oldPoint.getY() - currentPoint.getY());
            j = i;
        }

        return Math.abs(area / 2);
    }
}
