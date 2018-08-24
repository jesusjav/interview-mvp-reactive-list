package com.coding.framework.mvp.ui.main;

import android.support.annotation.StringRes;

import com.coding.framework.mvp.data.network.model.User;
import com.coding.framework.mvp.ui.base.MvpView;

import java.util.ArrayList;


/**
 * Created by Jesus Morales on 24-08-2018.
 */

public interface MainMvpView extends MvpView {

    void addUsers(ArrayList<User> users);

    void showErrorOnEditText(@StringRes int res);

}
