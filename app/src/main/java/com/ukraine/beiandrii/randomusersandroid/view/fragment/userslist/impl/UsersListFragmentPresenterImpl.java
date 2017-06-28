package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.impl;

import com.orhanobut.logger.Logger;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragment;
import com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist.UsersListFragmentPresenter;

/**
 * Created by psihey on 28.06.17.
 */

public class UsersListFragmentPresenterImpl implements UsersListFragmentPresenter {
    private UsersListFragment mUsersListFragment;

    @Override
    public void bindView(UsersListFragment usersListFragment) {
        this.mUsersListFragment = usersListFragment;
        Logger.d("Users List is binded to its presenter.");
    }

    @Override
    public void unbindView() {
        this.mUsersListFragment = null;
        Logger.d("Users List is unbinded from presenter");
    }
}
