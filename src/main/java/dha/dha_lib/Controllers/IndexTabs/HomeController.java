package dha.dha_lib.Controllers.IndexTabs;

import dha.dha_lib.Utils.API.APICallback;
import dha.dha_lib.Utils.API.ImageAPIAdapter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private ImageView bookImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageAPIAdapter imageAPIAdapter = new ImageAPIAdapter();
        imageAPIAdapter.fetch(
            "https://drive.google.com/uc?export=download&id=1mEbcbNI8XOZN08OOT3iS0kiyUV4hdRYU",
            new APICallback<Image>() {
                @Override
                public void onSuccess(Image result) {
                    System.out.println("Load Image success");
                    bookImageView.setImage(result);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("Load Image Failure");
                }
            }
        );
    }
}
