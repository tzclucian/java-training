package org.tzc.geometry.observer;

import java.util.List;

import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         26/10/15
 *         java-training
 *
 *         Observer interface
 */
public interface LayerProcessor {
    double process(List<Shape> shapes);
}
