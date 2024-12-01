module dha.dha_lib {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.xml;

    exports dha.dha_lib.Controllers;
    opens dha.dha_lib.Controllers to javafx.fxml;

    exports dha.dha_lib.Controllers.IndexTabs;
    opens dha.dha_lib.Controllers.IndexTabs to javafx.fxml;

    opens dha.dha_lib.Views to javafx.fxml;
    opens dha.dha_lib.Views.IndexTabs to javafx.fxml;

    opens dha.dha_lib to javafx.fxml;
    exports dha.dha_lib;
}
