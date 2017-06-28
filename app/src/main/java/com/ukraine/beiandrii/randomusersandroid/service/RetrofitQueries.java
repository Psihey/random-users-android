package com.ukraine.beiandrii.randomusersandroid.service;

import com.ukraine.beiandrii.randomusersandroid.model.UserJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by psihey on 28.06.17.
 */

public interface RetrofitQueries {
    @GET("api")
    Call<UserJson> getOneUser();

    @GET("api")
    Call<UserJson> getUsers(@Query("results") int numResults);

    @GET("api")
    Call<UserJson> getSameUsers(@Query("results") int numResults,@Query("seed") String feed);

    @GET("api")
    Call<UserJson> getUsersByNationally(@Query("results") int numResults, @Query("nat") String national);

    @GET("api")
    Call<UserJson> getUsersByGender(@Query("results") int numResults, @Query("gender") String gender);

}
