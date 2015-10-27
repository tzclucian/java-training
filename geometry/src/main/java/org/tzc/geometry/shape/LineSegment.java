package org.tzc.geometry.shape;

public class LineSegment implements Drawable {
    private Point a;
    private Point b;

    public LineSegment() {
    }

    public LineSegment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public double calculateLength() {
        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }

    public void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "LineSegment{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    /**
     * Computes the intersection between two segments.
     *
     * @param ab LineSegment
     * @return Point where the segments intersect, or null if they don't
     */
    public Point getIntersectionPoint(LineSegment ab) {

        double x1 = this.a.getX();
        double y1 = this.a.getY();

        double x2 = this.b.getX();
        double y2 = this.b.getY();

        double x3 = ab.getA().getX();
        double y3 = ab.getA().getY();

        double x4 = ab.getB().getX();
        double y4 = ab.getB().getY();

        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (d == 0) return null;

        double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

        Point p = new Point(xi, yi);
        if (xi < Math.min(x1, x2) || xi > Math.max(x1, x2)) return null;
        if (xi < Math.min(x3, x4) || xi > Math.max(x3, x4)) return null;
        return p;
    }

    /**
     * Computes the angle between two segments
     *
     * @param ab The other segment of the angle.
     * @return Angle value
     */
    public double calculateAngle(LineSegment ab) {
        double angle1 = this.calculateAngle();
        double angle2 = ab.calculateAngle();

        return Math.abs(angle2 - angle1);
    }

    /**
     * Computes the angle between the segment and oX
     *
     * @return Angle value
     */
    public double calculateAngle() {
        double sin = getB().getX() - getA().getX();
        double cos = getB().getY() - getA().getY();

        return Math.atan2(cos, sin);
    }
}
