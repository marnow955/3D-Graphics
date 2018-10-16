package main.java.camera;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import main.java.camera.utils.Box;
import main.java.camera.utils.Line3D;

import java.util.ArrayList;
import java.util.List;

public class Scene3D {
    Camera camera;
    private SubScene scene;
    private Group root;
    private final Canvas canvas;
    private GraphicsContext gc;
    private List<Box> boxes;

    public Scene3D(int width, int height) {
        root = new Group();
        scene = new SubScene(root, width, height);
        scene.setFill(Color.AQUA);
        canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        root.getChildren().add(canvas);
        boxes = new ArrayList<>();
        camera = new Camera();
    }

    public SubScene getScene3D() {
        return scene;
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public void draw() {
        for (Box box : boxes) {
            for (Line3D line : box.getLines()) {
                gc.strokeLine(line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY());
            }
        }
    }

    public void handleEvent(KeyCode code) {
        switch (code) {
            case DOWN:
                camera.moveBackward();
                break;
            case UP:
                camera.moveForward();
                break;
            case LEFT:
                camera.moveLeft();
                break;
            case RIGHT:
                camera.moveRight();
                break;
            case W:
                camera.rotateUp();
                break;
            case S:
                camera.rotateDown();
                break;
            case A:
                camera.rotateLeft();
                break;
            case D:
                camera.rotateRight();
                break;
            case CONTROL:
                camera.moveDown();
                break;
            case SHIFT:
                camera.moveUp();
                break;
            case PLUS:
                camera.zoomIn();
                break;
            case MINUS:
                camera.zoomOut();
                break;
        }
    }
}
