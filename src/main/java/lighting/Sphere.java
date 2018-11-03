package main.java.lighting;

import javafx.geometry.Point3D;

public class Sphere {
    Point3D center;
    double radius;

    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point3D getCrossPoint(Point3D observer, Point3D viewport) {
        double dx = viewport.getX() - observer.getX();
        double dy = viewport.getY() - observer.getY();
        double dz = viewport.getZ() - observer.getZ();


        double a = dx*dx + dy*dy + dz*dz;
        double b = 2 * (dx * (observer.getX() - center.getX()) + dy * (observer.getY() - center.getY()) +
                dz * (observer.getZ() - center.getZ()));
        double c = (observer.getX() - center.getX())*(observer.getX() - center.getX()) +
                (observer.getY() - center.getY())*(observer.getY() - center.getY()) +
                (observer.getZ() - center.getZ())*(observer.getZ() - center.getZ()) - radius*radius;

        double delta = b*b - 4 * a * c;

        if (delta < 0) {
            return null;
        } else if (delta == 0) {
            double t = -b / 2 * a;
            double x = observer.getX() + t * (viewport.getX() - observer.getX());
            double y = observer.getY() + t * (viewport.getY() - observer.getY());
            double z = observer.getZ() + t * (viewport.getZ() - observer.getZ());
            Point3D ret = new Point3D(x, y, z);
            return ret;
        } else {
            double t1 = (-b - Math.sqrt(delta)) / (2 * a);
            double t2 = (-b + Math.sqrt(delta)) / (2 * a);

            double t = Math.min(t1, t2);

            double x = observer.getX() + t * (viewport.getX() - observer.getX());
            double y = observer.getY() + t * (viewport.getY() - observer.getY());
            double z = observer.getZ() + t * (viewport.getZ() - observer.getZ());
            Point3D pkt1 = new Point3D(x, y, z);

            return pkt1;
        }
    }
}
