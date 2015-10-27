package org.tzc.geometry.layer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.tzc.geometry.shape.Shape;

/**
 * @author Lucian Tuca
 *         19/05/15
 *         java-training
 *
 *         Composite.
 */
public class CompositeLayer extends ArrayList<Layer> implements Layer {

    public void draw() {
        for (Layer layer : this) {
            layer.draw();
        }
    }

    /**
     * Returns all the elements got by BFS.
     *
     * @return List<Shape>
     */
    public List<Shape> listAllShapes() {
        List<Shape> allShapes = new ArrayList<Shape>();
        CompositeLayer layer;

        Queue<CompositeLayer> que = new ArrayDeque<CompositeLayer>();
        que.add(this);

        while (!que.isEmpty()) {
            layer = que.poll();

            for (Layer innerLayer : layer) {
                if (innerLayer instanceof Shape) {
                    allShapes.add((Shape) innerLayer);
                } else {
                    que.add((CompositeLayer) innerLayer);
                }
            }

        }
        return allShapes;
    }
}
