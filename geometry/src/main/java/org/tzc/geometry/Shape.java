package org.tzc.geometry;

import org.tzc.geometry.exceptions.GeometryException;
import org.tzc.geometry.layer.Leaf;


public abstract class Shape implements Drawable, Leaf {

    public abstract double calculatePerimeter() throws GeometryException;

    public abstract double calculateArea() throws GeometryException;

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
