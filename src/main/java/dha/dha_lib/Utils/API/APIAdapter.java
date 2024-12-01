package dha.dha_lib.Utils.API;

public interface APIAdapter<T> {
    void fetch(String apiUrl, APICallback<T> callback);
}
