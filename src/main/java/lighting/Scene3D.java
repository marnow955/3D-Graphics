package main.java.lighting;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Scene3D {

    public Color[][] sceneContent;
    private Scene scene;
    private PixelWriter pw;
    private int width;
    private int height;

    public Scene3D(int width, int height) {
        this.width = width;
        this.height = height;
        Group root = new Group();
        scene = new Scene(root, width, height);
        initSceneContent(Color.AQUA);
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pw = gc.getPixelWriter();
        root.getChildren().add(canvas);
    }

    public Scene getScene3D() {
        return scene;
    }

    public void draw() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pw.setColor(x, y, sceneContent[y][x]);
            }
        }
    }

    public void initSceneContent(Color backgroundColor) {
        sceneContent = new Color[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sceneContent[y][x] = backgroundColor;
            }
        }
    }
}
