package dha.dha_lib;

import dha.dha_lib.Effects.HoverEffect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {
    private static MainAppController instance;
    public static MainAppController getInstance() { return instance; }

    @FXML
    ImageView closeIcon;

    @FXML
    ImageView minimizeIcon;

    @FXML
    StackPane container;

    public static void loadPage(String fxmlPage) {
        FXMLLoader fxmlLoader = MainApp.getLoader(fxmlPage);
        try {
            Parent parent = fxmlLoader.load();
            instance.container.getChildren().clear();
            instance.container.getChildren().addAll(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instance = this;
        loadPage("Views/Login.fxml");
        HoverEffect.applyFadeEffect(closeIcon, 1, .7, 100);
        HoverEffect.applyFadeEffect(minimizeIcon, 1, .7, 100);
    }

    @FXML
    public void handleClose() {
        Stage stage = (Stage) closeIcon.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleMinimize() {
        Stage stage = (Stage) minimizeIcon.getScene().getWindow();
        stage.setIconified(true);
    }

}
