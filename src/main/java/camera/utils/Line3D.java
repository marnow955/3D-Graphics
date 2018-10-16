package main.java.camera.utils;

import javafx.geometry.Point3D;

public class Line3D {
    private Point3D start;
    private Point3D end;

    public Line3D(Point3D start, Point3D end) {
        this.start = start;
        this.end = end;
    }

    public Line3D(double xStart, double yStart, double zStart, double xEnd, double yEnd, double zEnd) {
        this.start = new Point3D(xStart, yStart, zStart);
        this.end = new Point3D(xEnd, yEnd, zEnd);
    }

    public Point3D getStart() {
        return start;
    }

    public void setStart(Point3D start) {
        this.start = start;
    }

    public Point3D getEnd() {
        return end;
    }

    public void setEnd(Point3D end) {
        this.end = end;
    }
}
