package main.java.camera.utils;

import javafx.geometry.Point3D;
import javafx.scene.shape.Line;

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

    public Line toLine(int focalLength, int cameraZ, double sceneWidth, double sceneHeight) {
        double xd = sceneWidth / 2;
        double yd = sceneHeight / 2;
        double zStart = focalLength / (start.getZ() - cameraZ);
        double xStart = zStart * start.getX() + xd;
        double yStart = yd - zStart * start.getY();

        double zEnd = focalLength / (end.getZ() - cameraZ);
        double xEnd = zEnd * end.getX() + xd;
        double yEnd = yd - zEnd * end.getY();

        return new Line(xStart, yStart, xEnd, yEnd);
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

    public double getStartX() {
        return start.getX();
    }

    public double getStartY() {
        return start.getY();
    }

    public double getStartZ() {
        return start.getZ();
    }

    public double getEndX() {
        return end.getX();
    }

    public double getEndY() {
        return end.getY();
    }

    public double getEndZ() {
        return end.getZ();
    }
}
