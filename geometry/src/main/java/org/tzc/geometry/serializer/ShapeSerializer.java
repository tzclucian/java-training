package org.tzc.geometry.serializer;

import org.tzc.geometry.layer.Layer;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public abstract class ShapeSerializer {
    public abstract String doSerialize(Layer layer);
}
