package com.android.mvp.presenter;

/**
 * Created by Alucard on 10/20/2016.
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

    void showListMovies(String apiKey);


}
