package com.indeco.trainingandroid.io.remote;

public interface UICallable<T> {
    void onResponse(T t);
    void onError(String message);
}
