package com.android.mvp.view;

/**
 * Created by Alucard on 10/19/2016.
 */

public interface ILoginView {
    void onClearTxt();
    void onLoginResult(boolean result, int code);
    void onSetProgressBarVisibility(int visibility);
}
