package org.tzc.geometry.shape.polygonal.triangle;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.tzc.geometry.shape.LineSegment;
import org.tzc.geometry.shape.Point;
import org.tzc.geometry.shape.Validable;

@Entity
@Table(name = "ISOSCELES_TRIANGLE")
public class IsoscelesTriangle extends Triangle implements Validable {

    @OneToOne
    @PrimaryKeyJoinColumn
    @Cascade(CascadeType.ALL)
    private LineSegment base;

    public IsoscelesTriangle() {
    }

    public IsoscelesTriangle(Point a, Point b, Point c) {
        super(a, b, c);
    }

    @Override
    public boolean check() {
        if (!super.check()) return false;

        List<LineSegment> segments = getSegments();

        LineSegment ab = segments.get(0);
        LineSegment bc = segments.get(1);
        LineSegment ca = segments.get(2);

        if ((ab.calculateLength() - bc.calculateLength()) < 0.01) {
            base = ca;
            return true;
        }
        if ((bc.calculateLength() - ca.calculateLength()) < 0.01) {
            base = ab;
            return true;
        }
        if ((ca.calculateLength() - ab.calculateLength()) < 0.01) {
            base = bc;
            return true;
        }

        return false;
    }

    public LineSegment getBase() {
        return base;
    }
}
