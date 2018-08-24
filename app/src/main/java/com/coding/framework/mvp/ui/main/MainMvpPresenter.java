package com.coding.framework.mvp.ui.main;


import com.coding.framework.mvp.di.PerActivity;
import com.coding.framework.mvp.ui.base.MvpPresenter;


/**
 * Created by Jesus Morales on 24-08-2018.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void loadUsers();

}
