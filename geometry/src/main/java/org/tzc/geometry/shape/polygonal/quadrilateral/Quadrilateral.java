package org.tzc.geometry.shape.polygonal.quadrilateral;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.polygonal.SimplePolygon;

import java.util.Arrays;

public class Quadrilateral extends SimplePolygon implements Validable {

    public Quadrilateral() {
    }

    public Quadrilateral(Point a, Point b, Point c, Point d) throws GeometryException {
        super(Arrays.asList(a, b, c, d));
    }
}
