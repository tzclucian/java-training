package org.tzc.geometry.visitor;

/**
 * @author Lucian Tuca
 *         22/05/15
 *         java-training
 */
public interface SerializableLayer {
    String serialize(ShapeSerializer serializer);
}
