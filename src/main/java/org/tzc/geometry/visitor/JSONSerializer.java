package org.tzc.geometry.visitor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.tzc.geometry.layer.Layer;

import java.io.IOException;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public class JSONSerializer extends ShapeSerializer {
    ObjectMapper objectMapper = new ObjectMapper();

    public String doSerialize(Layer layer) {
        try {
            return objectMapper.writeValueAsString(layer);
        } catch (IOException ex) {
            return "{error: " + ex.getLocalizedMessage() + "}";
        }
    }
}
