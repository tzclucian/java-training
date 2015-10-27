package org.tzc.geometry.serializer;

import org.tzc.geometry.layer.Layer;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 *
 *         Adapter for a serializable layer.
 */
public class SerializableLayerAdapter implements SerializableLayer {
    Layer layer;

    public SerializableLayerAdapter(Layer layer) {
        this.layer = layer;
    }

    public String serialize(ShapeSerializer serializer) {
        if (serializer != null) {
            return serializer.doSerialize(layer);
        }
        return "";
    }
}
