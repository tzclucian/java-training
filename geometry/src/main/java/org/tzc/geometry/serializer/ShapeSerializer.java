package org.tzc.geometry.serializer;

import org.tzc.geometry.layer.Layer;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public interface ShapeSerializer {
    String doSerialize(Layer layer);
}
