package dha.dha_lib.Utils.API;

public interface APICallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable throwable);
}
