package com.coding.framework.mvp.data.network;

import com.coding.framework.mvp.data.network.model.User;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
/**
 * Created by Jesus Morales on 24-08-2018.
 */
public interface ApiService {

    @GET("/users")
    Observable<ArrayList<User>> getUsers();

}
