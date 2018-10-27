package main.java.camera;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.java.camera.utils.Box;

public class Main extends Application {

    private static final int SCENE_WIDTH = 1000;
    private static final int SCENE_HEIGHT = 800;
    private static final int BOX_WIDTH = 100;
    private static final int BOX_HEIGHT = 100;
    private static final int BOX_DEPTH = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene3D scene3D = new Scene3D(SCENE_WIDTH, SCENE_HEIGHT);
//        globalRoot.setCenter(scene3D.getScene3D());
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(500, 600, 100)));
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(700, 600, 100)));
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(500, 400, 100)));
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(700, 400, 100)));
        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(-150, -50, 300)));
        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(50, -50, 300)));
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(-150, 150, 200)));
//        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(50, 150, 200)));

        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(-150, -50, 450)));
        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(50, -50, 450)));
        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(-150, 150, 450)));
        scene3D.addBox(new Box(BOX_WIDTH, BOX_HEIGHT, BOX_DEPTH, new Point3D(50, 150, 450)));

        scene3D.draw();
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            scene3D.handleEvent(event.getCode());
        });


        primaryStage.setTitle("Virtual Camera");
        primaryStage.setScene(scene3D.getScene3D());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
