package org.tzc.geometry.serializer;

import org.tzc.geometry.layer.Layer;
import org.tzc.geometry.serializer.SerializableLayer;
import org.tzc.geometry.serializer.ShapeSerializer;

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
