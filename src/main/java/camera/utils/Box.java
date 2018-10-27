package main.java.camera.utils;

import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private int width;
    private int height;
    private int depth;
    private Point3D leftBottomPoint;

    List<Line3D> lines;

    public Box(int width, int height, int depth, Point3D leftBottomPoint) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.leftBottomPoint = leftBottomPoint;
        buildBox();
    }

    public List<Line3D> getLines() {
        return lines;
    }

    private void buildBox() {
        lines = new ArrayList<>();
        double rightLineX = leftBottomPoint.getX() + width;
        double topLineY = leftBottomPoint.getY() - height;
        double backLineZ = leftBottomPoint.getZ() + depth;

        lines.add(new Line3D(leftBottomPoint, new Point3D(rightLineX, leftBottomPoint.getY(), leftBottomPoint.getZ())));
        lines.add(new Line3D(rightLineX, leftBottomPoint.getY(), leftBottomPoint.getZ(),
                rightLineX, topLineY, leftBottomPoint.getZ()));
        lines.add(new Line3D(rightLineX, topLineY, leftBottomPoint.getZ(),
                leftBottomPoint.getX(), topLineY, leftBottomPoint.getZ()));
        lines.add(new Line3D(new Point3D(leftBottomPoint.getX(), topLineY, leftBottomPoint.getZ()), leftBottomPoint));

        lines.add(new Line3D(leftBottomPoint.getX(), leftBottomPoint.getY(), backLineZ,
                rightLineX, leftBottomPoint.getY(), backLineZ));
        lines.add(new Line3D(rightLineX, leftBottomPoint.getY(), backLineZ,
                rightLineX, topLineY, backLineZ));
        lines.add(new Line3D(rightLineX, topLineY, backLineZ,
                leftBottomPoint.getX(), topLineY, backLineZ));
        lines.add(new Line3D(leftBottomPoint.getX(), topLineY, backLineZ,
                leftBottomPoint.getX(), leftBottomPoint.getY(), backLineZ));

        lines.add(new Line3D(leftBottomPoint, new Point3D(leftBottomPoint.getX(), leftBottomPoint.getY(), backLineZ)));
        lines.add(new Line3D(rightLineX, leftBottomPoint.getY(), leftBottomPoint.getZ(),
                rightLineX, leftBottomPoint.getY(), backLineZ));
        lines.add(new Line3D(leftBottomPoint.getX(), topLineY, leftBottomPoint.getZ(),
                leftBottomPoint.getX(), topLineY, backLineZ));
        lines.add(new Line3D(rightLineX, topLineY, leftBottomPoint.getZ(),
                rightLineX, topLineY, backLineZ));
    }

    public void moveHorizontal(double distance) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(line.getStartX() + distance, line.getStartY(), line.getStartZ()));
            line.setEnd(new Point3D(line.getEndX() + distance, line.getEndY(), line.getEndZ()));
        }
    }

    public void moveVertical(double distance) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(line.getStartX(), line.getStartY() + distance, line.getStartZ()));
            line.setEnd(new Point3D(line.getEndX(), line.getEndY() + distance, line.getEndZ()));
        }
    }

    public void moveZAxis(double distance) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(line.getStartX(), line.getStartY(), line.getStartZ() + distance));
            line.setEnd(new Point3D(line.getEndX(), line.getEndY(), line.getEndZ() + distance));
        }
    }

    public void rotateX(double step) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(line.getStartX(),
                    (line.getStartZ() * Math.sin(step)) + (line.getStartY() * Math.cos(step)),
                    (line.getStartZ() * Math.cos(step)) - (line.getStartY() * Math.sin(step))
            ));
            line.setEnd(new Point3D(line.getEndX(),
                    (line.getEndZ() * Math.sin(step)) + (line.getEndY() * Math.cos(step)),
                    (line.getEndZ() * Math.cos(step)) - (line.getEndY() * Math.sin(step))
            ));
        }
    }

    public void rotateY(double step) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(
                    (line.getStartX() * Math.cos(step)) - (line.getStartZ() * Math.sin(step)),
                    line.getStartY(),
                    (line.getStartX() * Math.sin(step)) + (line.getStartZ() * Math.cos(step))
            ));
            line.setEnd(new Point3D(
                    (line.getEndX() * Math.cos(step)) - (line.getEndZ() * Math.sin(step)),
                    line.getEndY(),
                    (line.getEndX() * Math.sin(step)) + (line.getEndZ() * Math.cos(step))
            ));
        }
    }

    public void rotateZ(double step) {
        for (Line3D line : lines) {
            line.setStart(new Point3D(
                    (line.getStartX() * Math.cos(step)) + (line.getStartY() * Math.sin(step)),
                    ((-1) * line.getStartX() * Math.sin(step)) + (line.getStartY() * Math.cos(step)),
                    line.getStartZ()
            ));
            line.setEnd(new Point3D(
                    (line.getEndX() * Math.cos(step)) + (line.getEndY() * Math.sin(step)),
                    ((-1) * line.getEndX() * Math.sin(step)) + (line.getEndY() * Math.cos(step)),
                    line.getEndZ()
            ));
        }
    }
}
