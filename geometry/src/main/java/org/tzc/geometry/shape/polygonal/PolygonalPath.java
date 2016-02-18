package org.tzc.geometry.shape.polygonal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;

@Entity
@Table(name = "POLYGONAL_PATH")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PolygonalPath extends Shape {

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "POINTS", joinColumns = @JoinColumn(name = "POINT_ID"))
    @Cascade(CascadeType.ALL)
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
    public double calculatePerimeter() {
        throw new GeometryException("Perimeter not supported for Polygonal Path");
    }

    @Override
    public double calculateArea() {
        throw new GeometryException("Area not supported for Polygonal Path");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PolygonalPath)) {
            return false;
        }
        PolygonalPath that = (PolygonalPath) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
