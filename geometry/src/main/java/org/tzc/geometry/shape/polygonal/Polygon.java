package org.tzc.geometry.shape.polygonal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;

@Entity
@Table(name = "POLYGON")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
    public double calculatePerimeter() {
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
