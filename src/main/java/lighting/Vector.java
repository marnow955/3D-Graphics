package main.java.lighting;

import javafx.geometry.Point3D;

public class Vector {

    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Point3D start, Point3D end) {
        this.x = end.getX() - start.getX();
        this.y = end.getY() - start.getY();
        this.z = end.getZ() - start.getZ();
    }

    public void normalize() {
        double norm = this.norm();
        this.x = x/norm;
        this.y = y/norm;
        this.z = z/norm;
    }

    public double norm() {
        return Math.sqrt(dotProduct(this));
    }

    // iloczyn skalarny
    public double dotProduct(Vector vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public Vector multiply(double d) {
        return new Vector(x*d, y*d, z*d);
    }

    public Vector diff(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }
}
