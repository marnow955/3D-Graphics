package main.java.camera;

import javafx.geometry.Point3D;

public class Camera {

    public static final int STEP_TRANSLATION = 30;
    public static final int ROTATE_DEGREES = 2;
    public static final double STEP_ROTATE = ROTATE_DEGREES * Math.PI/180;
    public static final int STEP_ZOOM = 15;

    private int focalLength;
    private int d; // odległość rzutni od kamery

    public Camera() {
        focalLength = 200;
        d = 0;
    }

    public void zoomIn() {
        focalLength += STEP_ZOOM;
    }

    public void zoomOut() {
        if(focalLength > 0)
            focalLength -= STEP_ZOOM;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public boolean isVisible(Point3D point) {
        if (point.getZ() >= focalLength)
            return true;
        return false;
    }
}
