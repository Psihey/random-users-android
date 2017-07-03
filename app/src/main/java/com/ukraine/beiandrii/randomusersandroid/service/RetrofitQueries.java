package com.ukraine.beiandrii.randomusersandroid.service;

import com.ukraine.beiandrii.randomusersandroid.model.UserJson;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by psihey on 28.06.17.
 */

public interface RetrofitQueries {

    @GET("api")
    Observable<UserJson> getOneUser();

    @GET("api")
    Observable<UserJson> getUsers(@Query("results") int numResults);

    @GET("api")
    Observable<UserJson> getSameUsers(@Query("results") int numResults,
                                      @Query("seed") String feed);

    @GET("api")
    Observable<UserJson> getUsersByNationally(@Query("results") int numResults,
                                              @Query("nat") String national);

    @GET("api")
    Observable<UserJson> getUsersByGender(@Query("results") int numResults,
                                          @Query("gender") String gender);

    @GET("api")
    Observable<UserJson> getUsersWithPagination(@Query("results") int numResults,
                                                @Query("page") int page,
                                                @Query("seed") String seed);

}
