package dha.dha_lib.Utils.API;

import javafx.concurrent.Task;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageAPIAdapter implements APIAdapter<Image> {

    @Override
    public void fetch(String apiUrl, APICallback<Image> callback) {
        Task<Image> task = new Task<Image>() {
            @Override
            protected Image call() throws Exception {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    throw new Exception("Failed to fetch image: " + connection.getResponseCode());
                }

                try (InputStream inputStream = connection.getInputStream()) {
                    return new Image(inputStream);
                }
            }
        };

        task.setOnSucceeded(event -> {
            if (callback != null) {
                callback.onSuccess(task.getValue());
            }
        });

        task.setOnFailed(event -> {
            if (callback != null) {
                callback.onFailure(task.getException());
            }
        });

        Thread thread = new Thread(task);

        thread.setDaemon(true);
        thread.start();
    }
}
