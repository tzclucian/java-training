package org.tzc.geometry.shape;

import org.tzc.geometry.layer.Leaf;


public abstract class Shape implements Drawable, Leaf {

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
