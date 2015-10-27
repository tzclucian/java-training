package org.tzc.geometry.observer;

import java.util.List;

import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         26/10/15
 *         java-training
 *
 *         Observer implementation
 */
public class TotalAreaCalculator implements LayerProcessor {
    public double process(List<Shape> shapes) {
        double totalArea = 0.0;
        for (Shape shape: shapes) {
            try {
                totalArea += shape.calculateArea();
            } catch (GeometryException ge) {
                ge.printStackTrace();
            }
        }

        return totalArea;
    }
}
