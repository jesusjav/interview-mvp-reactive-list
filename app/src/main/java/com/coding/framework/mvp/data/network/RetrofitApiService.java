package com.coding.framework.mvp.data.network;

import com.coding.framework.mvp.data.network.model.User;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by Jesus Morales on 24-08-2018.
 */
public class RetrofitApiService {

    private ApiService apiService;

    @Inject
    public RetrofitApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<ArrayList<User>> getUsers() {
        return apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



}
