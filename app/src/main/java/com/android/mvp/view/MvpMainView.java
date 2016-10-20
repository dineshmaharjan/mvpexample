package com.android.mvp.view;

import com.android.mvp.entity.MoviesResponse;

/**
 * Created by Alucard on 10/20/2016.
 */

public interface MvpMainView extends MvpView {

    void shoListofMovies(MoviesResponse moviesResponses);
    void showMessage(String message);
}
