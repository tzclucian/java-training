package org.tzc.geometry.polygonal;

import org.tzc.geometry.LineSegment;
import org.tzc.geometry.Point;
import org.tzc.geometry.exceptions.GeometryException;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends PolygonalPath {
    public Polygon() {
    }

    public Polygon(List<Point> points) {
        super.setPoints(points);
    }

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public double calculatePerimeter() throws GeometryException {
        return super.calculateLength();
    }

    @Override
    public List<LineSegment> getSegments() {
        List<LineSegment> segments = new ArrayList<LineSegment>();
        segments.addAll(super.getSegments());

        List<Point> points = getPoints();
        segments.add(new LineSegment(points.get(points.size() - 1), points.get(0)));

        return segments;
    }
}
