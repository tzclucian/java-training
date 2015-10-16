package org.tzc.geometry.builders;

import org.tzc.geometry.layer.CompositeLayer;
import org.tzc.geometry.layer.Layer;
import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         14/10/15
 *         java-training
 */
public class LayerBuilder {
    private CompositeLayer layer;

    public LayerBuilder() {
        this.layer = new CompositeLayer();
    }

    public LayerBuilder addShape(Shape shape) {
        this.layer.add(shape);
        return this;
    }

    public Layer build() {
        return layer;
    }

}
