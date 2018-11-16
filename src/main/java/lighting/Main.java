package main.java.lighting;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int SCENE_WIDTH = 450;
    private static final int SCENE_HEIGHT = 450;

    @Override
    public void start(Stage primaryStage) throws Exception {

        final int[] sphereVersion = {0};
        Scene3D scene3D = new Scene3D(SCENE_WIDTH, SCENE_HEIGHT);
        drawSphere(scene3D, Material.ODB_KIER.phong);
        primaryStage.setTitle("ODB_KIER");

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case LEFT:
                    sphereVersion[0] = sphereVersion[0] == 0 ? 4 : sphereVersion[0] - 1;
                    break;
                case RIGHT:
                    sphereVersion[0] = sphereVersion[0] == 4 ? 0: sphereVersion[0] + 1;
                    break;
            }
            Material material = Material.getMaterial(sphereVersion[0]);
            drawSphere(scene3D, material.phong);
            primaryStage.setTitle(material.toString());
        });

        primaryStage.setScene(scene3D.getScene3D());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    void drawSphere(Scene3D scene3D, Phong phong) {
        Point3D lightSource = new Point3D(5, 5, -5);
        Point3D sphereCenter = new Point3D(0, 0, 3);
        Point3D observer = new Point3D(0, 0, 0);
        Viewport viewport = new Viewport(SCENE_WIDTH, SCENE_HEIGHT,
                new Point3D(-1, -1, 1), new Point3D(1, 1, 1));

        Sphere sphere = new Sphere(sphereCenter, 1.5);
        Double maksI = 0.0;
        Double minI = 9999.0;
        Double[][] buforOswietlenia = new Double[SCENE_HEIGHT][SCENE_WIDTH];

        for (int y = 0; y < SCENE_HEIGHT; y++) {
            for (int x = 0; x < SCENE_WIDTH; x++) {
                Point3D p = viewport.getPoint(y, x);
                Point3D crossPoint = sphere.getCrossPoint(observer, p);
                Double I = phong.spherePointLighting(lightSource, observer, sphereCenter, crossPoint);
                if (I != null) {
                    if (I > maksI)
                        maksI = I;
                    if (I < minI)
                        minI = I;
                }
                buforOswietlenia[SCENE_HEIGHT - y - 1][x] = I;

            }
        }
        for (int y = 0; y < SCENE_HEIGHT; y++) {
            for (int x = 0; x < SCENE_WIDTH; x++) {
                Double I = buforOswietlenia[y][x];
                if (I != null) {
                    double f = I / (maksI + 0.02);
                    scene3D.sceneContent[y][x] = Color.color(f, f, f);
                }
            }
        }
        scene3D.draw();
    }
}
