package com.coding.framework.mvp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.coding.framework.mvp.R;
import com.coding.framework.mvp.adapter.UsersAdapter;
import com.coding.framework.mvp.data.network.model.User;
import com.coding.framework.mvp.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Jesus Morales on 24-08-2018.
 */

public class MainActivity extends BaseActivity implements MainMvpView {

    public static String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.users_recycler)
    RecyclerView mUsersRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    UsersAdapter mUsersAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MainActivity.this);

        setUp();

        mPresenter.loadUsers();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mUsersRecyclerView.setLayoutManager(mLayoutManager);
        mUsersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mUsersAdapter = new UsersAdapter(new ArrayList<User>());
        mUsersRecyclerView.setAdapter(mUsersAdapter);
    }


    @Override
    public void addUsers(ArrayList<User> users) {
        mUsersAdapter.addItems(users);
    }

    @Override
    public void showErrorOnEditText(@StringRes int res) {
        //show the error
    }
}
