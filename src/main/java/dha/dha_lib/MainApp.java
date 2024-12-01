package dha.dha_lib;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage primaryStage) throws IOException {
        StackPane root = new StackPane();
        root.setStyle(
            "-fx-background-color: #ffffff; -fx-background-radius: 30"
        );
        FXMLLoader fxmlLoader = MainApp.getLoader("MainAppView.fxml");
        Parent parent = fxmlLoader.load();
        root.getChildren().addAll(parent);
        Scene scene = new Scene(root, 1275, 720);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.setOnMousePressed(e -> {
            offsetX = e.getSceneX();
            offsetY = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - offsetX);
            primaryStage.setY(e.getScreenY() - offsetY);
        });
    }

    public static FXMLLoader getLoader(String fxmlFilePath) {
        return new FXMLLoader(MainApp.class.getResource(fxmlFilePath));
    }
}
