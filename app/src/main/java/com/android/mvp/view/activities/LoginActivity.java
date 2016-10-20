package com.android.mvp.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.mvp.R;
import com.android.mvp.presenter.ILoginPresenter;
import com.android.mvp.presenter.LoginPresenterImpl;
import com.android.mvp.view.ILoginView;

/**
 * Created by Dinesh on 10/19/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private EditText usernameTxt;
    private EditText passwordTxt;
    private Button loginBttn;
    private Button clearBttn;
    private ProgressBar progressBar;
    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        usernameTxt = (EditText) findViewById(R.id.usernameEditText);
        passwordTxt = (EditText) findViewById(R.id.passwordEditText);
        loginBttn = (Button) findViewById(R.id.loginBttn);
        clearBttn = (Button) findViewById(R.id.clearBttn);
        progressBar = (ProgressBar) findViewById(R.id.progress_login);
        loginBttn.setOnClickListener(this);
        clearBttn.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.progressBarVisibility(View.INVISIBLE);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.loginBttn:
                loginPresenter.progressBarVisibility(View.VISIBLE);
                loginBttn.setEnabled(false);
                clearBttn.setEnabled(false);
                loginPresenter.doLogin(usernameTxt.getText().toString(), passwordTxt.getText().toString());
                break;

            case R.id.clearBttn:
                loginPresenter.clear();
                break;
        }
    }

    @Override
    public void onClearTxt() {
        usernameTxt.setText("");
        passwordTxt.setText("");
    }

    @Override
    public void onLoginResult(boolean result, int code) {
        loginPresenter.progressBarVisibility(View.INVISIBLE);
        loginBttn.setEnabled(true);
        clearBttn.setEnabled(true);
        System.out.println("Result "+result);
        if (result) {
            loginPresenter.onLoginSuccess(this);
        } else {
            Toast.makeText(this, "Login Failed, code=" + code, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {

    }
}
