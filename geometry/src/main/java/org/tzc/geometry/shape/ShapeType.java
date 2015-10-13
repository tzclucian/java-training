package org.tzc.geometry.shape;

public enum ShapeType {
    ShapeType(null),
        Polygonal(ShapeType),
            Quadrilateral(Polygonal),
                PARALLELOGRAM(Quadrilateral),
                QUADRILATERAL(Quadrilateral),
                RECTANGLE(Quadrilateral),
                SQUARE(Quadrilateral),
            Triangle(Polygonal),
                EQUILATERAL_TRIANGLE(Triangle),
                ISOSCELES_TRIANGLE(Triangle),
                RIGHT_TRIANGLE(Triangle),
                TRIANGLE(Triangle),
            POLYGON(Polygonal),
            POLYGONAL_PATH(Polygonal),
        Rounded(ShapeType),
            CIRCLE(Rounded);

    private ShapeType parent = null;

    ShapeType(ShapeType parent) {
        this.parent = parent;
    }
}
