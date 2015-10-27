package org.tzc.geometry.serializer;

import java.io.IOException;

import org.tzc.geometry.layer.Layer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public class JSONSerializer implements ShapeSerializer {
    ObjectMapper objectMapper = new ObjectMapper();

    public String doSerialize(Layer layer) {
        try {
            return objectMapper.writeValueAsString(layer);
        } catch (IOException ex) {
            return "{error: " + ex.getLocalizedMessage() + "}";
        }
    }
}
