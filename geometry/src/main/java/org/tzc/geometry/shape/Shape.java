package org.tzc.geometry.shape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.tzc.geometry.layer.Leaf;

@Entity
@Table(name = "SHAPE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Shape implements Drawable, Leaf {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public void draw() {
        System.out.println(toString());
    }

    @Override
    public abstract String toString();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
