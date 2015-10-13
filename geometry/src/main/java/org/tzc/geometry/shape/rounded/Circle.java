package org.tzc.geometry.shape.rounded;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Shape;
import org.tzc.geometry.exceptions.GeometryException;

public class Circle extends Shape {

    private Point center;
    private long radiusLength;

    public Circle() {
    }

    public Circle(Point center, long radiusLength) {
        this.center = center;
        this.radiusLength = radiusLength;
    }

    @Override
    public double calculatePerimeter() throws GeometryException {
        return 2 * Math.PI * this.radiusLength;
    }

    @Override
    public double calculateArea() throws GeometryException {
        return Math.PI * (this.radiusLength * this.radiusLength);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public long getRadiusLength() {
        return radiusLength;
    }

    public void setRadiusLength(long radiusLength) {
        this.radiusLength = radiusLength;
    }
}
