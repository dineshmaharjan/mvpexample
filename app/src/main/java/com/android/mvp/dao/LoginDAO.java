package com.android.mvp.dao;

import com.android.mvp.entity.User;

/**
 * Created by Alucard on 10/19/2016.
 */

public interface LoginDAO {
    int checkUserValidity(String username, String password);

    void getUser(User user);
}
