package com.android.mvp.dao;

import com.android.mvp.entity.User;

/**
 * Created by Dinesh on 10/19/2016.
 */

public class LoginDAOImpl implements LoginDAO {


    User user;
    public LoginDAOImpl() {
       user=new User();
    }



    @Override
    public int checkUserValidity(String username, String password) {
        System.out.println("inside daoimpl"+username+password);
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            return 1;
        }else{
            return 0;

        }
    }

    @Override
    public void getUser(User user) {
        this.user=user;
    }


}
