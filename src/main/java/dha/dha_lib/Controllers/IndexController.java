package dha.dha_lib.Controllers;

import dha.dha_lib.MainApp;
import dha.dha_lib.MainAppController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    @FXML
    private AnchorPane tabContent;

    private void switchTab(String fxmlTabFile) {
        FXMLLoader fxmlLoader = MainApp.getLoader(fxmlTabFile);
        try {
            Parent parent = fxmlLoader.load();
            tabContent.getChildren().clear();
            tabContent.getChildren().addAll(parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchToHomeTab() {
        switchTab("Views/IndexTabs/Home.fxml");
    }

    @FXML
    public void switchToBorrowTab() {
        System.out.println("Switch to Borrow Tab");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchTab("Views/IndexTabs/Home.fxml");
    }
}
