package org.tzc.geometry.builders.triangle;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.polygonal.triangle.EquilateralTriangle;

public class EquilateralTriangleBuilder {
    private Point a;
    private Point b;
    private Point c;
    private EquilateralTriangle triangle;

    private void calculatePointsCoordinates(double sideLength) {
        this.a = new Point(0, 0);
        this.b = new Point(sideLength / 2.0, sideLength * Math.sqrt(3) / 2);
        this.c = new Point(sideLength, 0);
    }

    public EquilateralTriangleBuilder bySideLength(double sideLength) {
        calculatePointsCoordinates(sideLength);
        triangle = new EquilateralTriangle(a, b, c);
        return this;
    }

    public EquilateralTriangle build() {
        return triangle;
    }
}
