package com.android.mvp.presenter;

import android.app.Activity;

import com.android.mvp.dao.LoginDAO;
import com.android.mvp.dao.LoginDAOImpl;
import com.android.mvp.entity.User;
import com.android.mvp.navigation.Navigation;
import com.android.mvp.view.ILoginView;

/**
 * Created by Dinesh on 10/19/2016.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView;
    User user;
    LoginDAO loginDAO;
    Navigation navigation;


    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
    }

    @Override
    public void clear() {
        iLoginView.onClearTxt();

    }

    @Override
    public void doLogin(String username, String password) {

        loginDAO=new LoginDAOImpl();
        Boolean isLoginSuccess = true;
        Boolean result;

        System.out.println("username and password is"+username+password);

        loginDAO.getUser(user);
        int code = loginDAO.checkUserValidity(username,password);
        if (code == 0) {
            result = false;
        }else{
            result=isLoginSuccess;
        }
        System.out.println("Login code is"+code);
        iLoginView.onLoginResult(result, code);

    }

    @Override
    public void progressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    @Override
    public void onLoginSuccess(Activity activity) {
        navigation=new Navigation();
        navigation.setActivity(activity);
        navigation.goToMainActivity();

    }


    private void initUser() {
        user = new User(1,"guest","Guest123");
    }
}
