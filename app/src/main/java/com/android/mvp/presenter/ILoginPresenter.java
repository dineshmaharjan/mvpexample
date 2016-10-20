package com.android.mvp.presenter;

import android.app.Activity;

/**
 * Created by Dinesh on 10/19/2016.
 */

public interface ILoginPresenter {

    void clear();
    void doLogin(String username, String password);
    void progressBarVisibility(int visibility );
    void onLoginSuccess(Activity activity);

}
