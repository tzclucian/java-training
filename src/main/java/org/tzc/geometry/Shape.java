package org.tzc.geometry;

import org.tzc.geometry.exceptions.GeometryException;

public abstract class Shape implements Drawable {

    public abstract double getPerimeter() throws GeometryException;

    public abstract double getArea() throws GeometryException;

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
