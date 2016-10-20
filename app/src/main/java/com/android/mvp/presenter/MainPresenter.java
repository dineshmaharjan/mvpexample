package com.android.mvp.presenter;

import com.android.mvp.dao.MovieDao;
import com.android.mvp.entity.MoviesResponse;
import com.android.mvp.view.MvpMainView;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alucard on 10/20/2016.
 */

public class MainPresenter implements Presenter<MvpMainView> {
    public static String TAG = "MainPresenter";

    private MvpMainView mvpMainView;
    private Subscription subscription;
    private MoviesResponse moviesResponses;

    @Override
    public void attachView(MvpMainView view) {
        this.mvpMainView = view;
    }

    @Override
    public void detachView() {
        this.mvpMainView = null;
        if (subscription != null) {
            subscription.unsubscribe();
        }

    }

    @Override
    public void showListMovies(String apiKey) {
//        mvpMainView.shoListofMovies();
        MovieDao movieDao;
        movieDao = MovieDao.Factory.create();
        subscription = movieDao.getTopRatedMovies(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesResponse>() {
                    @Override
                    public void onCompleted() {

                            mvpMainView.shoListofMovies(moviesResponses);

                    }

                    @Override
                    public void onError(Throwable error) {

                        if (isHttp404(error)) {
                            mvpMainView.showMessage("failed o load");
                        } else {
                            mvpMainView.showMessage("success");
                        }

                    }

                    @Override
                    public void onNext(MoviesResponse moviesResponse) {
                        MainPresenter.this.moviesResponses=moviesResponse;
                    }


                });

    }

    private static boolean isHttp404(Throwable error) {
        return error instanceof HttpException && ((HttpException) error).code() == 404;
    }


}
