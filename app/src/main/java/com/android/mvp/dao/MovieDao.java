package com.android.mvp.dao;

import com.android.mvp.constant.ApiConstant;
import com.android.mvp.entity.MoviesResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Alucard on 10/20/2016.
 */

public interface MovieDao {
    @GET("movie/top_rated")
    Observable<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);
//    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    class Factory{
       public static MovieDao create(){
           Retrofit retrofit=new Retrofit.Builder()
                   .baseUrl(ApiConstant.BASE_RUL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                   .build();

           return retrofit.create(MovieDao.class);
       }

    }
}
