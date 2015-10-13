package org.tzc.geometry.shape.polygonal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.exceptions.GeometryException;

public class PolygonalPath extends Shape {
    private List<Point> points;

    public PolygonalPath() {
    }

    public PolygonalPath(List<Point> points) {
        this.points = points;
    }

    public PolygonalPath(Point... points) {
        this.setPoints(Arrays.asList(points));
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<LineSegment> getSegments() {
        List<LineSegment> segments = new ArrayList<LineSegment>();
        for (int i = 0; i < points.size() - 1; i++) {
            segments.add(new LineSegment(points.get(i), points.get(i + 1)));
        }

        return segments;
    }

    public double calculateLength() {
        double length = 0;
        for (LineSegment segment : getSegments()) {
            length += segment.calculateLength();
        }
        return length;
    }

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public double calculatePerimeter() throws GeometryException {
        throw new GeometryException("Perimeter not supported for Polygonal Path");
    }

    @Override
    public double calculateArea() throws GeometryException {
        throw new GeometryException("Area not supported for Polygonal Path");
    }
}
