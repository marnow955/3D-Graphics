package main.java.camera;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import main.java.camera.utils.Box;
import main.java.camera.utils.Line3D;

import java.util.ArrayList;
import java.util.List;

public class Scene3D {
    private Camera camera;
    private Scene scene;
    private Group root;
    private final Canvas canvas;
    private GraphicsContext gc;
    private List<Box> boxes;

    public Scene3D(int width, int height) {
        root = new Group();
        scene = new Scene(root, width, height);
        scene.setFill(Color.AQUA);
        canvas = new Canvas();
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        root.getChildren().add(canvas);
        boxes = new ArrayList<>();
        camera = new Camera();
    }

    public Scene getScene3D() {
        return scene;
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public void draw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Box box : boxes) {
            for (Line3D line3D : box.getLines()) {
                if (camera.isVisible(line3D.getStart()) || camera.isVisible(line3D.getEnd())) {
                    Line line = line3D.toLine(camera.getFocalLength(), camera.getD(), canvas.getWidth(), canvas.getHeight());
                    gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                }
            }
        }
    }

    public void handleEvent(KeyCode code) {
        switch (code) {
            case DOWN:
                for (Box box : boxes)
                    box.moveVertical(Camera.STEP_TRANSLATION);
                draw();
                break;
            case UP:
                for (Box box : boxes)
                    box.moveVertical(-Camera.STEP_TRANSLATION);
                draw();
                break;
            case LEFT:
                for (Box box : boxes)
                    box.moveHorizontal(Camera.STEP_TRANSLATION);
                draw();
                break;
            case RIGHT:
                for (Box box : boxes)
                    box.moveHorizontal(-Camera.STEP_TRANSLATION);
                draw();
                break;
            case ALT:
                for (Box box : boxes)
                    box.moveZAxis(Camera.STEP_TRANSLATION);
                draw();
                break;
            case SPACE:
                for (Box box : boxes)
                    box.moveZAxis(-Camera.STEP_TRANSLATION);
                draw();
                break;
            case W:
                for (Box box : boxes)
                    box.rotateX(-Camera.STEP_ROTATE);
                draw();
                break;
            case S:
                for (Box box : boxes)
                    box.rotateX(Camera.STEP_ROTATE);
                draw();
                break;
            case A:
                for (Box box : boxes)
                    box.rotateY(-Camera.STEP_ROTATE);
                draw();
                break;
            case D:
                for (Box box : boxes)
                    box.rotateY(Camera.STEP_ROTATE);
                draw();
                break;
            case Q:
                for (Box box : boxes)
                    box.rotateZ(Camera.STEP_ROTATE);
                draw();
                break;
            case E:
                for (Box box : boxes)
                    box.rotateZ(-Camera.STEP_ROTATE);
                draw();
                break;
            case PERIOD:
                camera.zoomIn();
                draw();
                break;
            case COMMA:
                camera.zoomOut();
                draw();
                break;
        }
    }
}
