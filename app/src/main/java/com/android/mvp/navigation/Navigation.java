package com.android.mvp.navigation;

import android.app.Activity;
import android.content.Intent;

import com.android.mvp.view.activities.SecondActivity;

/**
 * Created by Alucard on 10/19/2016.
 */

public class Navigation {

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void goToMainActivity(){
        finishCurrentActivity();
        Intent intent=new Intent(activity,SecondActivity.class);
        activity.startActivity(intent);
    }


    private void finishCurrentActivity(){
        activity.finish();
    }
}
