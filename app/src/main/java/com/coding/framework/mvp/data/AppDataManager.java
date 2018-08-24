package com.coding.framework.mvp.data;


import android.content.Context;

import com.coding.framework.mvp.data.network.RetrofitApiService;
import com.coding.framework.mvp.data.network.model.User;
import com.coding.framework.mvp.data.prefs.PreferencesHelper;
import com.coding.framework.mvp.di.ApplicationContext;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Jesus Morales on 24-08-2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final RetrofitApiService retrofitApiService;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          RetrofitApiService retrofitApiService) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        this.retrofitApiService = retrofitApiService;
    }

    @Override
    public Observable<ArrayList<User>> getUsers() {
        return retrofitApiService.getUsers();
    }
}
