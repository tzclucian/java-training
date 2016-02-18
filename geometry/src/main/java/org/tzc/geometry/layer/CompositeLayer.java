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
 *         <p/>
 *         Composite.
 */

public class CompositeLayer implements Layer {

    private List<Layer> shapes = new ArrayList<>();

    public void draw() {
        for (Layer layer : shapes) {
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

            for (Layer innerLayer : layer.getShapes()) {
                if (innerLayer instanceof Shape) {
                    allShapes.add((Shape) innerLayer);
                } else {
                    que.add((CompositeLayer) innerLayer);
                }
            }

        }
        return allShapes;
    }

    /**
     * Proxy method to add() method
     *
     * @param layer Layer that we want to add.
     * @return The same result as List's add.
     */
    public boolean add(Layer layer) {
        return this.shapes.add(layer);
    }

    /**
     * Proxy method to size() method.
     *
     * @return List's size.
     */
    public int size() {
        return this.shapes.size();
    }

    public List<Layer> getShapes() {
        return shapes;
    }

    public void setShapes(List<Layer> shapes) {
        this.shapes = shapes;
    }
}
