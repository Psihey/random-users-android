package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl;

import com.orhanobut.logger.Logger;
import com.ukraine.beiandrii.randomusersandroid.model.UserJson;
import com.ukraine.beiandrii.randomusersandroid.model.UserModel;
import com.ukraine.beiandrii.randomusersandroid.service.RetrofitProvider;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragment;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by psihey on 28.06.17.
 */

public class UsersListFragmentPresenterImpl implements UsersListFragmentPresenter {
    private UsersListFragment mUsersListFragment;
    private CompositeDisposable mCompositeDisposable;
    private List<UserJson> userJsons = new ArrayList<>();
    private List<UserModel> mUserModel = new ArrayList<>();

    @Override
    public void bindView(UsersListFragment usersListFragment) {
        this.mUsersListFragment = usersListFragment;
        mCompositeDisposable = new CompositeDisposable();
        getUsersFromServer();
        Logger.d("Users List is binded to its presenter.");
    }

    @Override
    public void unbindView() {
        this.mUsersListFragment = null;
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
        Logger.d("Users List is unbinded from presenter");
    }

    //TODO This is test connection yet , change this
    @Override
    public List<UserModel> getUsersForAdapter() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mUserModel;
    }


    private void getUsersFromServer() {
        mCompositeDisposable.add(RetrofitProvider.getRetrofit().getUsers(100)
                .subscribeOn(Schedulers.io())
                .filter(userJson -> !userJson.equals(null))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(UserJson androidList) {
        List<UserJson> userJsons = new ArrayList<>();
        userJsons.add(androidList);
        for (UserJson userJson : userJsons) {
            for (UserModel userModel : userJson.getResult()) {
                mUserModel.add(userModel);
                System.out.println(userModel);
            }
        }

    }

    //TODO implement open alert dialog
    private void handleError(Throwable error) {

//        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
