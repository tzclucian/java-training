package org.tzc.geometry.shape.polygonal.quadrilateral;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;
import org.tzc.geometry.shape.polygonal.SimplePolygon;

@Entity
@Table(name = "QUADRILATERAL")
public class Quadrilateral extends SimplePolygon implements Validable {

    public Quadrilateral() {
    }

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        super(Arrays.asList(a, b, c, d));
    }
}
