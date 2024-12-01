package dha.dha_lib.Controllers;

import dha.dha_lib.MainAppController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    public void handleLogin() {
        MainAppController.loadPage("Views/Index.fxml");
    }
}
