package com.ukraine.beiandrii.randomusersandroid.view.fragment.userslist;

/**
 * Created by psihey on 28.06.17.
 */

public interface UsersListFragmentPresenter {

    void bindView(UsersListFragment usersListFragment);

    void unbindView();

    void getUsersFromServer();

    void refreshUsers();


}
