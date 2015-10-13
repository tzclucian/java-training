package org.tzc.geometry.shape.polygonal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.exceptions.GeometryException;

public class Polygon extends PolygonalPath {
    public Polygon() {
    }

    public Polygon(List<Point> points) {
        super.setPoints(points);
    }

    public Polygon(Point... points) {
        super.setPoints(Arrays.asList(points));
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
