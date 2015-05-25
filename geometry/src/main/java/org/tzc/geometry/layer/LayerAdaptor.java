package org.tzc.geometry.layer;

import org.tzc.geometry.visitor.SerializableLayer;
import org.tzc.geometry.visitor.ShapeSerializer;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public class LayerAdaptor implements SerializableLayer {
    Layer layer;

    public LayerAdaptor(Layer layer) {
        this.layer = layer;
    }

    public String serialize(ShapeSerializer serializer) {
        if (serializer != null) {
            return serializer.doSerialize(layer);
        }
        return "";
    }
}
