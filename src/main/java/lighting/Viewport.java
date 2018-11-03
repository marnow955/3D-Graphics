package main.java.lighting;

import javafx.geometry.Point3D;

public class Viewport {
    int width;
    int height;
    Point3D leftBottomPoint;
    Point3D rightTopPoint;
    Point3D[][] points;

    public Viewport(int width, int height, Point3D leftBottomPoint, Point3D rightTopPoint) {
        double z = leftBottomPoint.getZ();
        this.width = width;
        this.height = height;
        this.leftBottomPoint = leftBottomPoint;
        this.rightTopPoint = rightTopPoint;
        points = new Point3D[height][width];
        double dx = (rightTopPoint.getX() - leftBottomPoint.getX()) / width;
        double dy = (rightTopPoint.getY() - leftBottomPoint.getY()) / height;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                points[y][x] = new Point3D(leftBottomPoint.getX() + x * dx, leftBottomPoint.getY() + y * dy, z);
            }
        }
    }

    public Point3D[][] getPoints() {
        return points;
    }

    public Point3D getPoint(int y, int x) {
        return points[y][x];
    }
}
