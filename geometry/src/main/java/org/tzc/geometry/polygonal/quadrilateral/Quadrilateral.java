package org.tzc.geometry.polygonal.quadrilateral;

import org.tzc.geometry.Point;
import org.tzc.geometry.Validable;
import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.polygonal.SimplePolygon;

import java.util.Arrays;

public class Quadrilateral extends SimplePolygon implements Validable {

    public Quadrilateral(Point a, Point b, Point c, Point d) throws GeometryException {
        super(Arrays.asList(a, b, c, d));
    }
}
