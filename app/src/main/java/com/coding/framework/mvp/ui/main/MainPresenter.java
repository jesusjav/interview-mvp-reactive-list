package com.coding.framework.mvp.ui.main;

import com.coding.framework.mvp.data.DataManager;
import com.coding.framework.mvp.data.network.model.User;
import com.coding.framework.mvp.ui.base.BasePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


/**
 * Created by Jesus Morales on 24-08-2018.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void loadUsers(){
        getMvpView().showLoading();

        getCompositeDisposable().add(
        getDataManager().getUsers()
                .subscribe(new Consumer<ArrayList<User>>() {
                    @Override
                    public void accept(ArrayList<User> users) throws Exception {
                        getMvpView().addUsers(users);
                        getMvpView().hideLoading();
                    }
                }));
    }

}
