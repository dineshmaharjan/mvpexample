package com.android.mvp.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.mvp.R;
import com.android.mvp.entity.Movie;
import com.android.mvp.entity.MoviesResponse;
import com.android.mvp.presenter.MainPresenter;
import com.android.mvp.view.MvpMainView;
import com.android.mvp.view.adapter.MoviesAdapter;

import java.util.List;

/**
 * Created by Alucard on 10/19/2016.
 */
public class SecondActivity  extends AppCompatActivity implements MvpMainView{

    private static final String TAG=SecondActivity.class.getSimpleName();
    private final static String API_KEY="Your key";
    private MainPresenter presenter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        presenter=new MainPresenter();
        presenter.attachView(this);
        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(), "No key",Toast.LENGTH_SHORT).show();
            return;
        }

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.showListMovies(API_KEY);

//        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
//
//        Call<MoviesResponse> call=apiInterface.getTopRatedMovies(API_KEY);
//        call.enqueue(new Callback<MoviesResponse>() {
//            @Override
//            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
//                int statusCode=response.code();
//                List<Movie> movies=response.body().getResults();
//                recyclerView.setAdapter(new MoviesAdapter(movies,R.layout.list_item_movie,getApplicationContext()));
//
//            }
//
//            @Override
//            public void onFailure(Call<MoviesResponse> call, Throwable t) {
//
//                Log.e(TAG,t.toString());
//            }
//        });
    }


    @Override
    public void shoListofMovies(MoviesResponse moviesResponses) {
        List<Movie> movies=moviesResponses.getResults();
        recyclerView.setAdapter(new MoviesAdapter(movies,R.layout.list_item_movie,getApplicationContext()));

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
